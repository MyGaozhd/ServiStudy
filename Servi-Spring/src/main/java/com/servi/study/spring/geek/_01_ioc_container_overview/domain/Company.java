package com.servi.study.spring.geek._01_ioc_container_overview.domain;

/**
 * 公司类
 *
 * @author servi
 * @since
 */
public class Company {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
