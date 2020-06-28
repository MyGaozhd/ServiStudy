package com.servi.study.javabase.serviceloader;

import com.servi.study.plugin.PluginsLoader;

import java.util.List;

/**
 * @author servi
 * @date 2020/6/28
 */
public class T1 {

    public static void main(String[] args) {
        List<ITestService> plugins = PluginsLoader.load(ITestService.class);

        plugins.forEach(p -> {
            System.out.println(p);
        });
    }
}
