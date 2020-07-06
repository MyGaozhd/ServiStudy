package com.servi.study.boot.controller;

import com.servi.study.boot.bean.User;
import com.servi.study.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class C04_Controller {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/alluser")
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @RequestMapping("/oneuser/{id}")
    @Cacheable(cacheNames = "userCache", key = "#id")
    public User getOneUser(@PathVariable String id) {
        System.out.println(" 查询user " + id);
        return userMapper.getUserById(id);
    }

    @RequestMapping("/saveUser")
    public List<User> insertUser() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(20 + i);
            user.setName("servi-" + i);
            user.setSex("男");
            userMapper.insertUser(user);
        }
        return getAllUser();
    }

    @RequestMapping("/deletealluser")
    public boolean deleteAllUser() {
        userMapper.deleteAllUser();
        return true;
    }
}
