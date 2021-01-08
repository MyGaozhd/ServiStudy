package com.servi.study.javabase.reflect;

import java.lang.reflect.Field;

/**
 * @author servi
 * @date 2020/12/29
 */
public class T0 {

    public static void main(String[] args) {
        Class<?> clazz = Son.class;
        Field[] fields = clazz.getDeclaredFields();
        Son son = new Son();
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].set(son,"name");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
