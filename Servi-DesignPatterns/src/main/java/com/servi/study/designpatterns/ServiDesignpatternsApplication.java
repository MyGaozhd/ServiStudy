package com.servi.study.designpatterns;

import com.servi.study.log.ServiLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiDesignpatternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiDesignpatternsApplication.class, args);

        ServiLogger.log(" start end ");
    }

}
