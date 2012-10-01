package com.thoughtworks.learnangularjs.config;

import org.apache.commons.logging.impl.SLF4JLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.List;

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = {"com.thoughtworks.learnangularjs.web.nonsecure"})
public class PublicWebConfig extends WebMvcConfigurationSupport {
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        addDefaultHandlerExceptionResolvers(exceptionResolvers);
        for (HandlerExceptionResolver exceptionResolver : exceptionResolvers) {
            if (exceptionResolver instanceof DefaultHandlerExceptionResolver) {
                ((DefaultHandlerExceptionResolver) exceptionResolver).setWarnLogCategory("ERROR");
            }
        }
    }
}
