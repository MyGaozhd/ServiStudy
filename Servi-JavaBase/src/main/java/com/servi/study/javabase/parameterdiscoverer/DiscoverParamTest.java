package com.servi.study.javabase.parameterdiscoverer;

import com.servi.study.json.IJsonUtil;
import org.springframework.core.DefaultParameterNameDiscoverer;

import java.lang.reflect.Method;

/**
 * @author servi
 * @date 2020/6/6
 */
public class DiscoverParamTest {

    public static void main(String[] args) {
        DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();

        Class<NeedDiscoverParam> clazz = NeedDiscoverParam.class;

        Method[] methods = clazz.getDeclaredMethods();

        for (Method m : methods) {

            String[] params = discoverer.getParameterNames(m);
            System.out.println(IJsonUtil.toJson(params));
        }
    }
}
