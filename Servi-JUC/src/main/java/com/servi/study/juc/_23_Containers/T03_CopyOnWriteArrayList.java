package com.servi.study.juc._23_Containers;

import java.util.concurrent.CopyOnWriteArrayList;

public class T03_CopyOnWriteArrayList {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> lists = new CopyOnWriteArrayList<>();
        lists.add("test");
        lists.get(0);
        lists.iterator();
    }
}
