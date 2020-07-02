package com.servi.study.boot.controller;

import com.servi.study.boot.bean.People;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author servi
 * @date 2020/7/2
 */
@RestController
public class C03_Controller {

    @Autowired
    private BeanFactory beanFactory;

    @RequestMapping("/c03")
    public String c03() {
        return beanFactory.getBean(People.class).toString();
    }
}
