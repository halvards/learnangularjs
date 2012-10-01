package com.thoughtworks.learnangularjs.config;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import java.util.List;

public abstract class BaseWebConfig extends WebMvcConfigurationSupport {
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        addDefaultHandlerExceptionResolvers(exceptionResolvers);
        for (HandlerExceptionResolver exceptionResolver : exceptionResolvers) {
            if (AbstractHandlerExceptionResolver.class.isAssignableFrom(exceptionResolver.getClass())) {
                ((AbstractHandlerExceptionResolver) exceptionResolver).setWarnLogCategory(DispatcherServlet.class.getName());
            }
        }
    }
}
