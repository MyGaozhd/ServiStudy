package com.servi.study.javabase.gbus.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface GBusInterface {

    /**
     * 需要调用的远程接口
     *
     * @return
     */
    public Class<?> clazz();
}
