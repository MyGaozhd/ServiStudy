package com.servi.study.spring.geek._08_configuration_metadata;

import com.servi.study.spring.geek._01_ioc_container_overview.domain.User;
import com.servi.study.spring.geek._01_ioc_container_overview.enums.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * 基于 XML 资源的 YAML 外部化配置示例
 *
 * @author servi
 * @since
 */
public class T06_XmlBasedYamlPropertySourceDemo {

    public static void main(String[] args) {
        // 创建 IoC 底层容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建 XML 资源的 BeanDefinitionReader
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 记载 XML 资源
        reader.loadBeanDefinitions("classpath:configuration-metadata\\yaml-property-source-context.xml");
        // 获取 Map YAML 对象
        Map<String, Object> yamlMap = beanFactory.getBean("yamlMap", Map.class);
        System.out.println(yamlMap);
    }
}
