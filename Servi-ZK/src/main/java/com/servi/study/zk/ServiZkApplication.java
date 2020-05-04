package com.servi.study.zk;

import com.servi.study.entry.User;
import com.servi.study.json.IJsonUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiZkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiZkApplication.class, args);

        IJsonUtil.toJson("start end ");
    }
}
