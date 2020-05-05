package com.servi.study.spring;

import com.servi.study.spring.config.DemoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        String[] names = context.getBeanDefinitionNames();

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
