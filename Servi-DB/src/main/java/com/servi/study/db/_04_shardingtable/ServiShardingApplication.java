package com.servi.study.db._04_shardingtable;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.servi.study.db._00_entity.User;
import com.servi.study.db._00_entity.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.servi.study.db._00_entity")
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class ServiShardingApplication implements CommandLineRunner {

    @Autowired
    UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(ServiShardingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setName("servi-sharding-01");
        user.setAge(20);
        user.setSex("男");

        userMapper.insertUser(user);
    }
}
