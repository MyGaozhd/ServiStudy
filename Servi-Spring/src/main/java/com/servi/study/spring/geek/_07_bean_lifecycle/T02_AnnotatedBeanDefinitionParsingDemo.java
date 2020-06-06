package com.servi.study.spring.geek._07_bean_lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * 注解 BeanDefinition 解析示例
 *
 * @author servi
 * @since
 */
public class T02_AnnotatedBeanDefinitionParsingDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 基于 Java 注解的 AnnotatedBeanDefinitionReader 的实现
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
        int beanDefinitionCountBefore = beanFactory.getBeanDefinitionCount();

        // 注册当前类（非 @Component class）
        beanDefinitionReader.register(T02_AnnotatedBeanDefinitionParsingDemo.class);

        beanDefinitionReader.registerBean(T02_AnnotatedBeanDefinitionParsingDemo.class, "annotatedBeanDefinitionParsingDemo");

        int beanDefinitionCountAfter = beanFactory.getBeanDefinitionCount();
        int beanDefinitionCount = beanDefinitionCountAfter - beanDefinitionCountBefore;
        System.out.println("已加载 BeanDefinition 数量：" + beanDefinitionCount);
        // 普通的 Class 作为 Component 注册到 Spring IoC 容器后，通常 Bean 名称为 annotatedBeanDefinitionParsingDemo
        // Bean 名称生成来自于 BeanNameGenerator，注解实现 AnnotationBeanNameGenerator
        T02_AnnotatedBeanDefinitionParsingDemo demo = beanFactory.getBean("t02_AnnotatedBeanDefinitionParsingDemo",
                T02_AnnotatedBeanDefinitionParsingDemo.class);
        System.out.println(demo);

        // Bean 名称生成来自于 BeanNameGenerator，注解实现 AnnotationBeanNameGenerator
        T02_AnnotatedBeanDefinitionParsingDemo demo1 = beanFactory.getBean("annotatedBeanDefinitionParsingDemo",
                T02_AnnotatedBeanDefinitionParsingDemo.class);
        System.out.println(demo1);
    }
}
