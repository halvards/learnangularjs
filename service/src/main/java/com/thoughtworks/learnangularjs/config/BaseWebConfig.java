package com.thoughtworks.learnangularjs.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

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

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter handlerAdapter = super.requestMappingHandlerAdapter();
        for (HttpMessageConverter<?> messageConverter : handlerAdapter.getMessageConverters()) {
            if (MappingJackson2HttpMessageConverter.class.isAssignableFrom(messageConverter.getClass())) {
                MappingJackson2HttpMessageConverter converter = (MappingJackson2HttpMessageConverter) messageConverter;
                converter.setPrettyPrint(true);
                converter.setPrefixJson(true);
            }
        }
        return handlerAdapter;
    }
}
