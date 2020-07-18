package com.servi.study.aop._01_jdk_proxy;

import java.lang.reflect.Proxy;

/**
 * @author servi
 * @date 2020/7/18
 */
public class T01_JDK_Proxy {

    public static void main(String[] args) {
        IService service = (IService) Proxy.newProxyInstance(T01_JDK_Proxy.class.getClassLoader(), new Class[]{IService.class}, new ServiceHandler(new ServiceImpl()));
        service.add(1, 2);
    }
}
