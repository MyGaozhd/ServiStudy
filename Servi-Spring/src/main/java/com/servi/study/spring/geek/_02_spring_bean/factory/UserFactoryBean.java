package com.servi.study.spring.geek._02_spring_bean.factory;

 import com.servi.study.spring.geek._01_ioc_container_overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link User} Bean 的 {@link FactoryBean} 实现
 *
 * @author servi
 * @since
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
