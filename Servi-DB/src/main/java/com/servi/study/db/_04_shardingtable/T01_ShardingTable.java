package com.servi.study.db._04_shardingtable;

import com.servi.study.db._00_entity.User;
import com.servi.study.db._00_entity.UserMapper;
import com.servi.study.json.IJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class T01_ShardingTable {

    @Autowired
    UserMapper userMapper;

    public void insert() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("servi-sharding-" + i);
            user.setAge(20);
            user.setUser_id(i);
            user.setSex("男");
            userMapper.insertUser(user);
        }
    }

    public void query() {
        System.out.println(IJsonUtil.toJson(userMapper.getAllUser()));
    }
}
