package com.servi.study.aop._03_InstantiationAwareBeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author servi
 * @date 2020/7/25
 */
@Component
public class T01_InstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("com.servi.study.aop._03_InstantiationAwareBeanPostProcessor");
        configApplicationContext.getBean(Target.class).test();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (Target.class == bean.getClass()) {

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Target.class);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    Object result = null;
                    try {
                        System.out.println("test开始");
                        result = methodProxy.invokeSuper(o, objects);
                    } catch (Exception e) {
                        System.out.println("test异常");
                    } finally {
                        System.out.println("test结束：" + result);
                    }
                    return result;
                }
            });

            Target target = (Target) enhancer.create();
            return target;
        }

        return null;
    }
}
