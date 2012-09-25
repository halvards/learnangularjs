package com.thoughtworks.learnangularjs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath*:spring/applicationContext-security.xml")
public class SecurityConfig {
}
