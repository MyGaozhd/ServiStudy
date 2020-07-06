package com.servi.study.boot.controller;

import com.servi.study.start.autoconfigure.ServiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class C06_Controller {

    @Autowired
    private ServiService serviService;

    @RequestMapping("/serviservice")
    public void serviService() {
        serviService.log(" serviService ");
    }
}
