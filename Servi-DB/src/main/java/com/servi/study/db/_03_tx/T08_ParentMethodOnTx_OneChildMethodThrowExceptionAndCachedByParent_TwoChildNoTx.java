package com.servi.study.db._03_tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author servi
 * @date 2020/7/18
 */
@Component
public class T08_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedByParent_TwoChildNoTx {

    @Autowired
    Child child;

    @Transactional
    public void insert() {

        child.method1();
        try {
            child.method2();
        } catch (Exception e) {

        }
    }

    @Component
    class Child {

        String sql = "INSERT INTO `user` (name,sex,age) VALUES (?,?,?)";

        @Autowired
        JdbcTemplate jdbcTemplate;

        public void method1() {

            int count = jdbcTemplate.update(sql, new Object[]{"servi-t08-1", "男", 22});
            System.out.println("insert->" + count);
        }

        public void method2() {
            int count = jdbcTemplate.update(sql, new Object[]{"servi-t08-2", "男", 22});
            System.out.println("insert->" + count);
            //方法二 抛出异常
            throw new RuntimeException();

        }
    }
}
