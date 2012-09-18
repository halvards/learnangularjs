package com.thoughtworks.learnangularjs.server;

import org.apache.catalina.Context;
import org.apache.catalina.deploy.FilterDef;
import org.apache.catalina.deploy.FilterMap;
import org.apache.catalina.startup.Tomcat;

public class TomcatServer {
    private static final int PORT = 8000;

    public static void main(String[] args) throws Exception {
        new TomcatServer().run(args);
    }

    public void run(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);
        tomcat.setBaseDir(System.getProperty("java.io.tmpdir"));
        tomcat.getHost().setAppBase(System.getProperty("user.dir"));

        Context applicationContext = tomcat.addWebapp("/service", "src/main/webapp");
        Context staticFilesContext = tomcat.addWebapp("/app", "../client/src/main/webapp");

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
}
