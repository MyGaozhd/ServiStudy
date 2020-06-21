package com.servi.study.spring.geek._08_configuration_metadata;

import com.servi.study.spring.geek._01_ioc_container_overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Spring XML 元素扩展示例
 *
 * @author servi
 * @see [configuration-metadata\\users-context.xml]
 * @see [META-INF\\spring.handlers]
 * @see [META-INF\\spring.schemas]
 * @see [resources\\com\\servi\\study\\spring\\geek\\_08_configuration_metadata\\users.xsd]
 * @see UserBeanDefinitionParser
 * @see UsersNamespaceHandler
 * @since
 */
public class T04_ExtensibleXmlAuthoringDemo {

    public static void main(String[] args) {
        // 创建 IoC 底层容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建 XML 资源的 BeanDefinitionReader
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 记载 XML 资源
        reader.loadBeanDefinitions("configuration-metadata\\users-context.xml");
        // 获取 User Bean 对象
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }
}
