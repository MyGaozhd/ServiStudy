package com.servi.study.boot.controller;

import com.servi.study.boot.bean.Dog;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class C02_Controller {

    @Autowired
    private Dog dog;

    @RequestMapping("/c02")
    public String c02() {
        return dog.toString();
    }
}
