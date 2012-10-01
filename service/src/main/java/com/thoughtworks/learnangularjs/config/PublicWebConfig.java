package com.thoughtworks.learnangularjs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import java.util.List;

@Configuration
@ComponentScan(basePackages = {"com.thoughtworks.learnangularjs.web.nonsecure"})
public class PublicWebConfig extends BaseWebConfig {
}
