package com.thoughtworks.learnangularjs.server;

import org.apache.catalina.Context;
import org.apache.catalina.deploy.FilterDef;
import org.apache.catalina.deploy.FilterMap;
import org.apache.catalina.startup.Tomcat;
import org.apache.commons.cli.*;

public class TomcatServer {
    // These default directories are relative to the root project directory, they are overridden in the Gradle build script
    private static final String DEFAULT_SERVICE_BASE_DIR = "service/src/main/webapp";
    private static final String DEFAULT_CLIENT_BASE_DIR = "client/src/main/webapp";
    private static final String DEFAULT_PORT = "8000";

    private static final String OPTION_SERVICE_BASE_DIR = "serviceBaseDir";
    private static final String OPTION_CLIENT_BASE_DIR = "clientBaseDir";
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

        Context applicationContext = tomcat.addWebapp("/service", commandLine
                .getOptionValue(OPTION_SERVICE_BASE_DIR, DEFAULT_SERVICE_BASE_DIR));
        Context staticFilesContext = tomcat.addWebapp("/app", commandLine
                .getOptionValue(OPTION_CLIENT_BASE_DIR, DEFAULT_CLIENT_BASE_DIR));

        ensureNoBrowserCaching(applicationContext);
        ensureNoBrowserCaching(staticFilesContext);

        tomcat.start();
        tomcat.getServer().await();
    }

    private void ensureNoBrowserCaching(Context context) {
        context.addFilterDef(createNoCacheFilter());
        context.addFilterMap(createNoCacheFilterMapping());
    }

    private FilterMap createNoCacheFilterMapping() {
        FilterMap filterMapping = new FilterMap();
        filterMapping.setFilterName("nocache");
        filterMapping.addURLPattern("/*");
        return filterMapping;
    }

    private FilterDef createNoCacheFilter() {
        FilterDef filterDefinition = new FilterDef();
        filterDefinition.setFilterName("nocache");
        filterDefinition.setFilterClass("org.apache.catalina.filters.ExpiresFilter");
        filterDefinition.addInitParameter("ExpiresDefault", "access plus 0 seconds");
        return filterDefinition;
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
        options.addOption("svc", OPTION_SERVICE_BASE_DIR, true,
                          "Base directory for service web application, defaults to '" + DEFAULT_SERVICE_BASE_DIR + "'");
        options.addOption("app", OPTION_CLIENT_BASE_DIR, true,
                          "Base directory for client application, defaults to '" + DEFAULT_CLIENT_BASE_DIR + "'");
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
