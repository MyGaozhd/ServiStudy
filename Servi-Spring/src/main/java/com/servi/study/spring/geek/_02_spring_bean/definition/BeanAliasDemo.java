package com.servi.study.spring.geek._02_spring_bean.definition;

 import com.servi.study.spring.geek._01_ioc_container_overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 *
 * @author servi
 * @since
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/spring-bean/bean-definitions-context.xml");
        // 通过别名 servi-user 获取曾用名 user 的 bean
        User user = beanFactory.getBean("user", User.class);
        User serviUser = beanFactory.getBean("servi-user", User.class);
        System.out.println("servi-user 是否与 user Bean 相同：" + (user == serviUser));
    }
}
