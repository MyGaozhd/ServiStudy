package com.servi.study.spring.geek._07_bean_lifecycle;

import com.servi.study.spring.geek._01_ioc_container_overview.domain.SuperUser;
import com.servi.study.spring.geek._01_ioc_container_overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.ObjectUtils;

/**
 * BeanDefinition 合并示例
 *
 * @author servi
 * @since
 */
public class T04_BeanInstantiationLifecycleDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new TestInstantiationAwareBeanPostProcessor());
        // 基于 XML 资源 BeanDefinitionReader 实现
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String[] locations = {"ioc-container-overview\\dependency-lookup-context.xml", "bean_lifecycle\\bean-constructor-dependency-injection.xml"};

        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(locations);

        System.out.println("已加载 BeanDefinition 数量：" + beanNumbers);
        // 通过 Bean Id 和类型进行依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);

        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);

        // 构造器注入按照类型注入，resolveDependency
        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);
    }

    static class TestInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            System.out.println("postProcessBeforeInstantiation:" + this);

            if (ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(beanClass)) {
                return new SuperUser();
            }

            return null;
        }

        /**
         * superUser 因为实现了  postProcessBeforeInstantiation 会跳过此方法
         */
        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

            System.out.println("postProcessAfterInstantiation:" + this);

            if (ObjectUtils.nullSafeEquals("user", beanName) && bean.getClass().equals(User.class)) {
                User user = (User) bean;
                user.setId(22L);
                return false;
            }

            return true;
        }

        /**
         * user、superuser 都会跳过此方法
         */
        @Override
        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {


            if (ObjectUtils.nullSafeEquals("userHolder", beanName) && bean.getClass().equals(UserHolder.class)) {

                MutablePropertyValues propertyValues = new MutablePropertyValues();
                propertyValues.add("number", "666");

                return propertyValues;
            }
            return null;
        }
    }
}
