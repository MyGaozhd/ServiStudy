package com.servi.study.boot.config.servlet;

import com.servi.study.boot.servlet.ServiServlet;
import com.servi.study.boot.servlet.ServiServletListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author servi
 * @date 2020/7/4
 */
@Configuration
public class ServiServletConfiguration {

    @Bean
    public ServletRegistrationBean serviServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ServiServlet(), "/servlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean serviServletListener() {
        ServletListenerRegistrationBean<ServiServletListener> registrationBean = new ServletListenerRegistrationBean<>(new ServiServletListener());
        return registrationBean;
    }
}
