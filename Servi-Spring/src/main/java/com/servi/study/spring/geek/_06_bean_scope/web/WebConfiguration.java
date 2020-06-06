package com.servi.study.spring.geek._06_bean_scope.web;

import com.servi.study.spring.geek._01_ioc_container_overview.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Web MVC 配置类
 *
 * @author servi
 * @since
 */
@Configuration
@EnableWebMvc
public class WebConfiguration {

    @Bean
//    @RequestScope
//    @SessionScope
    @ApplicationScope
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("Servi");
        return user;
    }

}
