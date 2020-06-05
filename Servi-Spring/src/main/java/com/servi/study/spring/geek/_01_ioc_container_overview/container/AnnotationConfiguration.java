package com.servi.study.spring.geek._01_ioc_container_overview.container;

import com.servi.study.spring.geek._01_ioc_container_overview.domain.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfiguration {

    @Bean
    public Company Company() {
        Company company = new Company();
        company.setName("servi company");
        return company;
    }
}
