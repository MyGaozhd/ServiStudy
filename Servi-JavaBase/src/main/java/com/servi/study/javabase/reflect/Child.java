package com.servi.study.javabase.reflect;

import com.servi.study.json.IJsonUtil;

import java.io.IOException;
import java.lang.reflect.Field;

public class Child extends Father {
    private String secondName;

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public static void main(String[] args) throws IOException {

        Class<Child> c = Child.class;

        Field[] fields = c.getDeclaredFields();
        Field[] fields1 = c.getSuperclass().getDeclaredFields();
        Field[] fields2= c.getFields();
        System.in.read();
    }
}
