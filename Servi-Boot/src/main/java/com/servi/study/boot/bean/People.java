package com.servi.study.boot.bean;

import lombok.Data;

import java.util.List;

@Data
public class People {
    private String name;
    private List<Dog> pets;
}
