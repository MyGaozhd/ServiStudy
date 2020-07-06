package com.servi.study.start.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(ServiProperties.class)
public class ServiServiceAutoConfiguration {
    @Autowired
    private ServiProperties properties;

    @Bean
    public ServiService getServiService() {

        return new ServiService(properties);
    }
}
