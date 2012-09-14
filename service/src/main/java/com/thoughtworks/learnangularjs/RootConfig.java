package com.thoughtworks.learnangularjs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.support.MBeanServerFactoryBean;

@Configuration
@ComponentScan(basePackages = {"com.thoughtworks.learnangularjs"})
public class RootConfig {
    @Bean
    public static MBeanExporter mBeanExporter() {
        MBeanExporter mBeanExporter = new MBeanExporter();
        MBeanServerFactoryBean mBeanServerFactoryBean = new MBeanServerFactoryBean();
        mBeanServerFactoryBean.setLocateExistingServerIfPossible(true);
        mBeanExporter.setServer(mBeanServerFactoryBean.getObject());
        return mBeanExporter;
    }
}
