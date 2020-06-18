/**
 * 判断class 中字段和方法的修饰符
 */
package com.servi.study.javabase.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @author servi
 */
public class Modifier {

    public static void main(String[] args) {
        Class<M> clazz = M.class;

        Method[] methods = clazz.getDeclaredMethods();

        Stream.of(methods).forEach(m -> {
            System.out.println("method-" + m.getName() + " isSynchronized :" + java.lang.reflect.Modifier.isSynchronized(m.getModifiers()));
            System.out.println("method-" + m.getName() + " isStatic :" + java.lang.reflect.Modifier.isStatic(m.getModifiers()));
            System.out.println();
        });

        Field[] fields = clazz.getDeclaredFields();
        Stream.of(fields).forEach(f -> {
            System.out.println("field-" + f.getName() + " isVolatile :" + java.lang.reflect.Modifier.isVolatile(f.getModifiers()));
            System.out.println("field-" + f.getName() + " isFinal :" + java.lang.reflect.Modifier.isFinal(f.getModifiers()));
            System.out.println("field-" + f.getName() + " isStatic :" + java.lang.reflect.Modifier.isStatic(f.getModifiers()));
            System.out.println();
        });
    }

    static class M {
        private final String f0 = null;
        private volatile String f1 = null;
        private static String f2 = null;

        synchronized void m1() {

        }

        static void m2() {

        }
    }
}
