package com.servi.study.spring.geek._01_ioc_container_overview;

import com.servi.study.spring.geek._01_ioc_container_overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * {@link BeanFactory} 作为 IoC 容器示例
 *
 * @author servi
 * @since
 */
public class T03_BeanFactoryAsIoContainerDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // XML 配置文件 ClassPath 路径
        String location = "classpath:ioc-container-overview/dependency-lookup-context.xml";
        // 加载配置
        int beanDefinitionsCount = reader.loadBeanDefinitions(location);
        System.out.println("Bean 定义加载的数量：" + beanDefinitionsCount);
        // 依赖查找集合对象
        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + users);
        }
    }
}