package com.servi.study.aop._01_jdk_proxy;

import com.servi.study.aop._00_target.IService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author servi
 * @date 2020/7/18
 */
public class ServiceHandler implements InvocationHandler {

    private IService tagert;

    public ServiceHandler(IService tagert) {
        this.tagert = tagert;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = null;
        try {
            System.out.println("计算开始");
            o = method.invoke(tagert, args);
        } catch (Throwable e) {
            System.out.println("--计算异常--");
        } finally {
            System.out.println("计算结束：" + o);
        }
        return o;
    }
}
