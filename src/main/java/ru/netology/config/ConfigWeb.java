package ru.netology.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
public class ConfigWeb {
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        final var requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        requestMappingHandlerAdapter.getMessageConverters().add(new GsonHttpMessageConverter());
        return requestMappingHandlerAdapter;
    }

}
