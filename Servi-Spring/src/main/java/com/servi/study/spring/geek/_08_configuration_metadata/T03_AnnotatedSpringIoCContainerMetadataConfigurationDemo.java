package com.servi.study.spring.geek._08_configuration_metadata;

import com.servi.study.spring.geek._01_ioc_container_overview.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Map;

/**
 * 基于 Java 注解 Spring IoC 容器元信息配置示例
 *
 * @author servi
 * @since
 */
// 将当前类作为 Configuration Class
@ImportResource("classpath:ioc-container-overview\\dependency-lookup-context.xml")
@Import(User.class)
@PropertySource("classpath:configuration-metadata\\user-bean-definitions.properties") // Java 8+ @Repeatable 支持
@PropertySource("classpath:configuration-metadata\\user-bean-definitions.properties")
// @PropertySources(@PropertySource(...))
public class T03_AnnotatedSpringIoCContainerMetadataConfigurationDemo {

    /**
     * user.name 是 Java Properties 默认存在，当前用户：mercyblitz，而非配置文件中定义"Servi"
     * @param id
     * @param name
     * @return
     */
    @Bean
    public User configuredUser(@Value("${user.id}") Long id, @Value("${user.name}") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前类作为 Configuration Class
        context.register(T03_AnnotatedSpringIoCContainerMetadataConfigurationDemo.class);
        // 启动 Spring 应用上下文
        context.refresh();
        // beanName 和 bean 映射
        Map<String, User> usersMap = context.getBeansOfType(User.class);
        for (Map.Entry<String, User> entry : usersMap.entrySet()) {
            System.out.printf("User Bean name : %s , content : %s \n", entry.getKey(), entry.getValue());
        }
        // 关闭 Spring 应用上下文
        context.close();
    }
}
