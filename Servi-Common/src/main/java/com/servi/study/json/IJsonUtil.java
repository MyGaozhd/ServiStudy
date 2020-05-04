package com.servi.study.json;

import com.google.gson.Gson;

public class IJsonUtil {

    private static Gson gson = new Gson();

    private IJsonUtil() {
    }

    public static String toJson(Object o) {
        return gson.toJson(o);
    }

    public static <T> T fromJson(Class<T> classOfT, String json) {

        return gson.fromJson(json, classOfT);
    }
}
