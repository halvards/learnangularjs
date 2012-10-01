package com.thoughtworks.learnangularjs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.thoughtworks.learnangularjs.web.secure"})
public class SecureWebConfig extends BaseWebConfig {
}
