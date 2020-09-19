package com.servi.study.extend.compare;

import com.servi.study.json.IJsonUtil;

import java.util.*;

/**
 * @author servi
 * @date 2020/9/19
 */
public class Test {
    public static void main(String[] args) {

        List<String> aa = new ArrayList<>();
        aa.add("c");
        aa.add("a");
        aa.add("b");
        System.out.println(IJsonUtil.toJson(aa));
        Collections.sort(aa, new Comparator<String>() {
            @Override
            public int compare(String vo1, String vo2) {
                System.out.println(vo1.compareTo(vo2));
                return vo1.compareTo(vo2);
            }
        });

        System.out.println(IJsonUtil.toJson(aa));
    }
}
