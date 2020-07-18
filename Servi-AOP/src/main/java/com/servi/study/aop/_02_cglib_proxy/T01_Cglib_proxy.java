package com.servi.study.aop._02_cglib_proxy;

import com.servi.study.aop._00_target.ServiceImpl;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author servi
 * @date 2020/7/18
 */
public class T01_Cglib_proxy {
    private MethodProxy methodProxy;

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\class");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                try {
                    System.out.println("开始计算");
                    result = methodProxy.invokeSuper(o, objects);
                } catch (Exception e) {
                    System.out.println("计算异常");
                } finally {
                    System.out.println("计算结束：" + result);
                }
                return result;
            }
        });
        ServiceImpl service = (ServiceImpl) enhancer.create();

        System.out.println(service.add(1, 2));
    }
}
