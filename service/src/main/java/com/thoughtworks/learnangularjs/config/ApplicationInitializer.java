package com.thoughtworks.learnangularjs.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

/**
 * https://github.com/kolorobot/spring-mvc-quickstart-archetype/blob/master/src/main/resources/archetype-resources/src/main/java/config/WebAppInitializer.java
 */
public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));
        servletContext.setInitParameter("defaultHtmlEscape", "true");
        servletContext.setInitParameter("defaultXmlEscape", "true");

        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(WebConfig.class);
        ServletRegistration.Dynamic appServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(mvcContext));
        appServlet.setLoadOnStartup(1);
        Set<String> mappingConflicts = appServlet.addMapping("/*");
        if (!mappingConflicts.isEmpty()) {
            throw new IllegalStateException("'dispatcherServlet' cannot be mapped to '/' under Tomcat");
        }
    }
}
