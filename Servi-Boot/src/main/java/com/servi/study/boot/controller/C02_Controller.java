package com.servi.study.boot.controller;

import com.servi.study.boot.bean.Dog;
import com.servi.study.boot.bean.People;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class C02_Controller {

    @Autowired
    private Dog dog;

    @Autowired
    private People people;

    @RequestMapping("/c02_1")
    public String c02_1() {
        return dog.toString();
    }

    @RequestMapping("/c02_2")
    public String c02_2() {
        return people.toString();
    }
}
