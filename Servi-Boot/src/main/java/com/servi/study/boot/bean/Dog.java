package com.servi.study.boot.bean;

import lombok.Data;

@Data
public class Dog {
    private Animal.Species species;
    private String name;
    private String sex;
    private int age;
}
