package com.servi.study.juc;

import com.servi.study.log.ServiLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiJucApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiJucApplication.class, args);
        ServiLogger.log(" start end ");
    }
}
