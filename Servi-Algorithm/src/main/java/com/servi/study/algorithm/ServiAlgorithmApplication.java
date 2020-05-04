package com.servi.study.algorithm;

import com.servi.study.log.ServiLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiAlgorithmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiAlgorithmApplication.class, args);
        ServiLogger.log(" start end ");
    }
}
