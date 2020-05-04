package com.servi.study.log;

import com.servi.study.entry.User;
import com.servi.study.json.IJsonUtil;

public class ServiLogger {

    private ServiLogger() {
    }

    public static void main(String[] args) {
        ServiLogger.log("123");
        ServiLogger.log(new User("123","123"));
    }

    public static void log(String log) {
        System.out.println(log);
    }

    public static <T> void log(T o) {
        System.out.println(IJsonUtil.toJson(o));
    }
}
