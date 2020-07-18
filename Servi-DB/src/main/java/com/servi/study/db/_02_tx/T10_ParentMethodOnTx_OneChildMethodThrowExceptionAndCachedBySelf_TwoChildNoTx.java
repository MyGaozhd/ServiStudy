package com.servi.study.db._02_tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author servi
 * @date 2020/7/18
 */
@Component
public class T10_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedBySelf_TwoChildNoTx {

    @Autowired
    Child child;

    public void insert() {

        child.method1();
        child.method2();
    }

    @Component
    class Child {

        String sql = "INSERT INTO `user` (name,sex,age) VALUES (?,?,?)";

        @Autowired
        JdbcTemplate jdbcTemplate;

        public void method1() {

            int count = jdbcTemplate.update(sql, new Object[]{"servi-t10-1", "男", 22});
            System.out.println("insert->" + count);
        }

        public void method2() {
            int count = jdbcTemplate.update(sql, new Object[]{"servi-t10-2", "男", 22});
            System.out.println("insert->" + count);
            try {
                //方法二 抛出异常
                throw new RuntimeException();
            } catch (Exception e) {

            }
        }
    }
}
