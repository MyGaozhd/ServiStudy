package com.servi.study.spring.start;

import com.servi.study.spring.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/start/start_test.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.hashCode());

        IStartTestService startTestService = (IStartTestService) context.getBean("startTestService");

        System.out.println(startTestService.test());
    }
}
