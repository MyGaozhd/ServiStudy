package com.servi.study.zk.curator;

import com.servi.study.json.IJsonUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiZKApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiZKApplication.class, args);

        IJsonUtil.toJson("start end ");
    }
}
