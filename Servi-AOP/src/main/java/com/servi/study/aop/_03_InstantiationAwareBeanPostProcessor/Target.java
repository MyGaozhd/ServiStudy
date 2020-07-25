package com.servi.study.aop._03_InstantiationAwareBeanPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Target {

    private String name = "target";

    public Target() {
    }

    public Target(String name) {
        this.name = name;
    }

    public void test() {
        System.out.println(name + "->test");
    }
}
