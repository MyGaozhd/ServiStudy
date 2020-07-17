package com.servi.study.db._02_tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Component
public class T01_Transactional_Normal {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public void insert() {
        String sql = "INSERT INTO `servi-db`.`user` (name,sex,age) VALUES (?,?,?)";
        int count = jdbcTemplate.update(sql, new Object[]{"servi-00", "男", 22});

        System.out.println("insert->" + count);
    }
}
