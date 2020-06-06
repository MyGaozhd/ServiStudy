package com.servi.study.spring.geek._05_dependency_source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * ResolvableDependency 作为依赖来源
 *
 * @author servi
 * @since
 */
public class T02_ResolvableDependencySourceDemo {

    @Autowired
    private String value;

    @PostConstruct
    public void init() {
        System.out.println(value);
    }

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(T02_ResolvableDependencySourceDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            // 注册 Resolvable Dependency
            beanFactory.registerResolvableDependency(String.class, "Hello,World");
        });

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}
