package com.thoughtworks.learnangularjs.server;

import org.apache.catalina.Context;
import org.apache.catalina.Realm;
import org.apache.catalina.deploy.FilterDef;
import org.apache.catalina.deploy.FilterMap;
import org.apache.catalina.filters.ExpiresFilter;
import org.apache.catalina.realm.MemoryRealm;
import org.apache.catalina.startup.Tomcat;
import org.apache.commons.cli.*;
import org.apache.tomcat.util.scan.StandardJarScanner;

public class TomcatServer {
    private static final String DEFAULT_PORT = "8000";
    private static final String OPTION_PORT = "port";
    private static final String OPTION_HELP = "help";

    public static void main(String[] args) throws Exception {
        new TomcatServer().run(args);
    }

    public void run(String[] args) throws Exception {
        CommandLine commandLine = parseCommandLine(args);
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.valueOf(commandLine.getOptionValue("port", DEFAULT_PORT)));
        tomcat.setBaseDir(System.getProperty("java.io.tmpdir"));
        tomcat.getHost().setAppBase(System.getProperty("user.dir"));

        tomcat.getHost().setRealm(createRealm());

        Context serviceContext = tomcat.addWebapp("/service", "src/main/webapp");
        ((StandardJarScanner) serviceContext.getJarScanner()).setScanAllDirectories(true);
        ensureNoBrowserCaching(serviceContext);

        Context clientContext = tomcat.addWebapp("/app", "../client/src/main/webapp");
        ensureNoBrowserCaching(clientContext);

        tomcat.start();
        tomcat.getServer().await();
    }

    private Realm createRealm() {
        MemoryRealm realm = new MemoryRealm();
        realm.setPathname(System.getProperty("user.dir") + "/src/test/resources/tomcat-users.xml");
        return realm;
    }

    private void ensureNoBrowserCaching(Context context) {
        context.addFilterDef(createNoCacheFilter());
        context.addFilterMap(createNoCacheFilterMapping());
    }

    private FilterMap createNoCacheFilterMapping() {
        FilterMap expiresFilterMapping = new FilterMap();
        expiresFilterMapping.setFilterName("expires");
        expiresFilterMapping.addURLPattern("/*");
        return expiresFilterMapping;
    }

    private FilterDef createNoCacheFilter() {
        FilterDef expiresFilterDefinition = new FilterDef();
        expiresFilterDefinition.setFilterName("expires");
        expiresFilterDefinition.setFilterClass(ExpiresFilter.class.getName());
        expiresFilterDefinition.addInitParameter("ExpiresDefault", "access plus 0 seconds");
        return expiresFilterDefinition;
    }

    private CommandLine parseCommandLine(String[] args) throws ParseException {
        Options options = createCommandLineOptions();
        CommandLine line = null;
        try {
            line = new GnuParser().parse(options, args);
            handleHelpOptionIfPresent(options, line);
        } catch (UnrecognizedOptionException e) {
            printHelp(options, e.getMessage());
            System.exit(1);
        }
        return line;
    }

    private Options createCommandLineOptions() {
        Options options = new Options();
        options.addOption("p", OPTION_PORT, true, "Port number used by the server, defaults to " + DEFAULT_PORT);
        options.addOption("h", OPTION_HELP, false, "Display this help text");
        return options;
    }

    private void handleHelpOptionIfPresent(Options options, CommandLine line) {
        if (line.hasOption(OPTION_HELP)) {
            printHelp(options, "");
            System.exit(0);
        }
    }

    private void printHelp(Options options, String prefix) {
        new HelpFormatter().printHelp(prefix + "java " + getClass().getName(), options);
    }
}
