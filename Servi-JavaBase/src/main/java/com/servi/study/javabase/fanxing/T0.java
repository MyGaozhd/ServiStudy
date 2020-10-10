package com.servi.study.javabase.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author servi
 * @date 2020/10/10
 */
public class T0 {
    public static void main(String[] args) {
        List<? extends Food> list1 = new ArrayList<>();
        //compile error
        //list1.add(new Fruit());

        List<? super Food> list2 = new ArrayList<>();
        list2.add(new Fruit());
        //compile error
        //Food f = list2.get(0);

        list1 = (List<? extends Food>) list2;
        list1.get(0);

        List<Food> list3 = new ArrayList<>();
        list3.add(new Food());
        list3.add(new Fruit());
        list3.add(new Apple());

        List<? extends Food> list4 = list3;
        list4.get(0);
    }

    public static <T extends Food> Food get(T t) {
        return t;
    }

    private static class Food {
        String name;
    }

    private static class Fruit extends Food {

    }

    private static class Apple extends Fruit {

    }
}
