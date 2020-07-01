package com.servi.study.boot.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C01_Controller {

    @ResponseBody
    @RequestMapping("/c01")
    public String c01() {
        return C01_Controller.class + "c01";
    }
}
