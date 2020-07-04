package com.servi.study.boot.config;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author servi
 * @date 2020/7/4
 */
public class GlobleWebMvcConfigurer implements WebMvcConfigurer {
    //configureDefaultServletHandling

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }
}
