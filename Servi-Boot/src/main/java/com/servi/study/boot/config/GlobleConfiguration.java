package com.servi.study.boot.config;


import com.servi.study.boot.bean.Dog;
import com.servi.study.boot.bean.People;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobleConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "dog")
    public Dog dog() {
        return new Dog();
    }

    @Bean
    @ConfigurationProperties(prefix = "people")
    public People people() {
        return new People();
    }
}
