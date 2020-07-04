package com.servi.study.boot.config.filter;

import com.servi.study.boot.filter.ServiFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author servi
 * @date 2020/7/4
 */
@Configuration
public class ServiFilterConfiguration {

    @Bean
    public FilterRegistrationBean serviFilterRegistrationBean() {
        FilterRegistrationBean serviFilterRegistrationBean = new FilterRegistrationBean(new ServiFilter());
        serviFilterRegistrationBean.addUrlPatterns("/servi", "/");
        return serviFilterRegistrationBean;
    }
}
