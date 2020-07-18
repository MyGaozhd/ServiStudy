package com.servi.study.db._02_tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @see T01_Transactional_Normal 正常开启一个事务且没有异常【事务不回滚】
 * @see T02_Transactional_RollBack_On_Exception 正常开启一个事务且存在异常【事务回滚】
 * @see T03_ParentMethodNoTx_TwoChildMethodNoException 父方法没有开启事务，子方法分别开启事务，且都没有抛出异常【事务不回滚】
 * @see T04_ParentMethodNoTx_OneChildMethodThrowException 父方法没有开启事务，子方法分别开启事务，且第二个子方法抛出异常【child1 不回滚，child2 回滚】
 */
@SpringBootApplication
@EnableTransactionManagement
public class ServiTXApplication implements CommandLineRunner {

    @Autowired
    T01_Transactional_Normal t01_transactional_normal;

    @Autowired
    T02_Transactional_RollBack_On_Exception t02_transactional_rollBack_on_exception;

    @Autowired
    T03_ParentMethodNoTx_TwoChildMethodNoException t03_parentMethodNoTx_twoChildMethodNoException;

    @Autowired
    T04_ParentMethodNoTx_OneChildMethodThrowException t04_parentMethodNoTx_oneChildMethodThrowException;

    public static void main(String[] args) {
        SpringApplication.run(ServiTXApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //t01_transactional_normal();
        //t02_transactional_rollBack_on_exception();

        //t03_parentMethodNoTx_twoChildMethodNoException();
        t04_parentMethodNoTx_oneChildMethodThrowException();

    }

    public void t01_transactional_normal() {
        t01_transactional_normal.insert();
    }

    public void t02_transactional_rollBack_on_exception() {
        t02_transactional_rollBack_on_exception.insert();
    }

    public void t03_parentMethodNoTx_twoChildMethodNoException() {
        t03_parentMethodNoTx_twoChildMethodNoException.insert();
    }

    public void t04_parentMethodNoTx_oneChildMethodThrowException() {
        t04_parentMethodNoTx_oneChildMethodThrowException.insert();
    }


}
