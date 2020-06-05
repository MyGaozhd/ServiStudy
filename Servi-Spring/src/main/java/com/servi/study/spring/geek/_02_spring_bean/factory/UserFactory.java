package com.servi.study.spring.geek._02_spring_bean.factory;

 import com.servi.study.spring.geek._01_ioc_container_overview.domain.User;

/**
 * {@link User} 工厂类
 *
 * @author servi
 * @since
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }
}
