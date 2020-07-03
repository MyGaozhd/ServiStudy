package com.servi.study.spring.geek._01_ioc_container_overview;

import com.servi.study.spring.geek._01_ioc_container_overview.domain.Company;
import com.servi.study.spring.geek._01_ioc_container_overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 注解能力 {@link ApplicationContext} 作为 IoC 容器示例
 *
 * @author servi
 * @since
 */
@Configuration
public class T04_AnnotationApplicationContextAsIoContainerDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 AnnotationApplicationContextAsIoCContainerDemo 作为配置类（Configuration Class）
        applicationContext.register(T04_AnnotationApplicationContextAsIoContainerDemo.class);
        //扫描包
        applicationContext.scan("com.servi.study.spring.geek.ioc_container_overview.container");
        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找集合对象
        lookupCollectionByType(applicationContext);

        // 关闭应用上下文
        applicationContext.close();

    }

    /**
     * 通过 Java 注解的方式，定义了一个 Bean
     */
    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName(" Servi");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + users);

            //没有扫描此包，会报错
            System.out.println("查找到的所有的 Company 对象：" + listableBeanFactory.getBean(Company.class));
        }
    }

}
