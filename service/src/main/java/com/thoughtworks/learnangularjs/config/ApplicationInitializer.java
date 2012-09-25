package com.thoughtworks.learnangularjs.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

/**
 * https://github.com/kolorobot/spring-mvc-quickstart-archetype/blob/master/src/main/resources/archetype-resources/src/main/java/config/WebAppInitializer.java
 */
public class ApplicationInitializer implements WebApplicationInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        LOG.info(getClass().getSimpleName() + " starting");

        servletContext.setInitParameter("defaultHtmlEscape", "true");
        servletContext.setInitParameter("defaultXmlEscape", "true");

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class, SecurityConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
                .addMappingForUrlPatterns(null, false, "/secure/*");

        addDispatcherServlet(servletContext, PublicWebConfig.class, "public");
        addDispatcherServlet(servletContext, SecureWebConfig.class, "secure");
    }

    private void addDispatcherServlet(ServletContext servletContext, Class applicationContextClass, String contextPath) {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(applicationContextClass);
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet(contextPath + "DispatcherServlet", new DispatcherServlet(webContext));
        dispatcherServlet.setLoadOnStartup(1);
        Set<String> mappingConflicts = dispatcherServlet.addMapping("/" + contextPath + "/*");
        if (!mappingConflicts.isEmpty()) {
            throw new IllegalStateException("Servlets cannot be mapped to '/' under Tomcat. Use '/*' instead.");
        }
    }
}
