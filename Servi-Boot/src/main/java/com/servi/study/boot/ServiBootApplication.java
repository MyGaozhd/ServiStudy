package com.servi.study.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ServiBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiBootApplication.class, args);
    }
}
