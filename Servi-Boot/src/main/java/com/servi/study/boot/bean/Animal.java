package com.servi.study.boot.bean;

import lombok.Data;

@Data
public class Animal {

    private Species species;

    public enum Species {
        DOG,
        CAT
    }
}
