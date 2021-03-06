package com.servi.study.spring.geek._01_ioc_container_overview.domain;


import com.servi.study.spring.geek._01_ioc_container_overview.annotation.Super;

/**
 * 超级用户
 *
 * @author servi
 * @since
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
