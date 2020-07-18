package com.servi.study.db._02_tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author servi
 * @date 2020/7/18
 */
@Component
public class T05_ParentMethodOnTx_TwoChildMethodNoException {
    @Autowired
    Child child;

    @Transactional
    public void insert() {

        child.method1();
        child.method2();
    }

    @Component
    class Child {

        String sql = "INSERT INTO `user` (name,sex,age) VALUES (?,?,?)";

        @Autowired
        JdbcTemplate jdbcTemplate;

        @Transactional
        public void method1() {

            int count = jdbcTemplate.update(sql, new Object[]{"servi-t05-1", "男", 22});
            System.out.println("insert->" + count);
        }

        @Transactional
        public void method2() {
            int count = jdbcTemplate.update(sql, new Object[]{"servi-t05-2", "男", 22});
            System.out.println("insert->" + count);
        }
    }
}
