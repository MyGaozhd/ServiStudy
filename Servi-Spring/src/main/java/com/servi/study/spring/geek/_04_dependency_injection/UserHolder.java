package com.servi.study.spring.geek._04_dependency_injection;

import com.servi.study.spring.geek._01_ioc_container_overview.domain.User;

/**
 * {@link User} 的 Holder 类
 *
 * @author servi
 * @since
 */
public class UserHolder {

    private User user;

    public UserHolder() {
    }

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
