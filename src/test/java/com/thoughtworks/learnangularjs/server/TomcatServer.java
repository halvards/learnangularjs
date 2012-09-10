package com.thoughtworks.learnangularjs.server;

import org.apache.catalina.Context;
import org.apache.catalina.deploy.FilterDef;
import org.apache.catalina.deploy.FilterMap;
import org.apache.catalina.startup.Tomcat;

public class TomcatServer {
    private static final String CONTEXT_PATH = "/";
    private static final int PORT = 8000;
    private static final String APPLICATION_BASE_DIRECTORY = "src/main/webapp";

    public static void main(String[] args) throws Exception {
        new TomcatServer().run(args);
    }

    public void run(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);
        tomcat.setBaseDir(System.getProperty("java.io.tmpdir"));
        tomcat.getHost().setAppBase(System.getProperty("user.dir"));

        Context context = tomcat.addWebapp(CONTEXT_PATH, APPLICATION_BASE_DIRECTORY);
        ensureNoBrowserCaching(context);

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
}
