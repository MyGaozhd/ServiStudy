package com.servi.study.javabase.serviceloader;

import java.util.ServiceLoader;

/**
 * @author servi
 * @date 2020/6/23
 * @see [META-INF\services\com.servi.study.javabase.serviceloader.ITestService]
 */
public class T {

    public static void main(String[] args) {

        ServiceLoader<ITestService> services = ServiceLoader.load(ITestService.class, ITestService.class.getClassLoader());
        services.forEach(t -> {
            t.test();
        });
    }
}
