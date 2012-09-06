package com.thoughtworks.learnangularjs.server;

import org.apache.catalina.startup.Tomcat;

public class TomcatServer {

    private static final String CONTEXT_PATH = "/";
    private static final int PORT = 8000;
    private static final String APPLICATION_BASE_DIRECTORY = "src/main/webapp";

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);
        tomcat.setBaseDir(System.getProperty("java.io.tmpdir"));
        tomcat.getHost().setAppBase(System.getProperty("user.dir"));
//        tomcat.getServer().addLifecycleListener(new AprLifecycleListener());

        tomcat.addWebapp(CONTEXT_PATH, APPLICATION_BASE_DIRECTORY);

        tomcat.start();
        tomcat.getServer().await();
    }
}
