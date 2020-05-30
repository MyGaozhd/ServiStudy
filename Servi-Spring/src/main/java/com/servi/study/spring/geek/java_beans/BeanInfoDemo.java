package com.servi.study.spring.geek.java_beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * @author servi
 * @date 2020/5/30
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo info = Introspector.getBeanInfo(Person.class,Object.class);

        Stream.of(info.getPropertyDescriptors()).forEachOrdered(p -> {
            System.out.println(p);
            System.out.println("=================================");
            System.out.println(p.getName());

            System.out.println("=================================");
            System.out.println(p.isHidden());
        });
    }
}
