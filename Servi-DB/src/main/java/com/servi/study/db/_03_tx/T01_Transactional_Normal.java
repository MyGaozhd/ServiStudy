package com.servi.study.db._03_tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * 正常开启一个事务且没有异常
 */
@Component
public class T01_Transactional_Normal {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public void insert() {
        String sql = "INSERT INTO `user` (name,sex,age) VALUES (?,?,?)";
        int count = jdbcTemplate.update(sql, new Object[]{"servi-t01", "男", 22});

        System.out.println("insert->" + count);
    }
}
