package com.servi.study.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ServiDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiDbApplication.class, args);
    }

}
