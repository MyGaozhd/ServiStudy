package com.servi.study.boot.bean;

import lombok.Data;

@Data
public class Dog extends Animal {
    private String name;
    private String sex;
    private int age;
}
