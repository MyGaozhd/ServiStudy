package com.servi.study.db._02_tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @see T01_Transactional_Normal 正常开启一个事务且没有异常
 * 【事务不回滚】
 * @see T02_Transactional_RollBack_On_Exception 正常开启一个事务且存在异常
 * 【事务回滚】
 * @see T03_ParentMethodNoTx_TwoChildMethodNoException 父方法没有开启事务，子方法分别开启事务，且都没有抛出异常
 * 【事务不回滚】
 * @see T04_ParentMethodNoTx_OneChildMethodThrowException 父方法没有开启事务，子方法分别开启事务，且第二个子方法抛出异常
 * 【child1 不回滚，child2 回滚】
 * @see T05_ParentMethodOnTx_TwoChildMethodNoException
 * 【事务不回滚】
 * @see T06_ParentMethodOnTx_OneChildMethodThrowExceptionAndNoCached
 * 【两个都回滚】
 * @see T07_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedByParent
 * 【两个都回滚】
 * @see T08_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedByParent_TwoChildNoTx
 * [两个都不回滚]
 * @see T09_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedBySelf
 * 【两个都不回滚】
 * @see T10_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedBySelf_TwoChildNoTx
 * 【两个都不回滚】
 * @see T11_ParentMethodNoTx_TwoChildMethod_RequiresNew
 * [两个都不回滚]
 * @see T12_ParentMethodNoTx_OneChildMethodThrowExceptionAndNoCached_RequiresNew
 * [child1 不回滚 child2 回滚]
 * @see T13_ParentMethodNoTx_OneChildMethodThrowExceptionAndCachedBySelf_RequiresNew
 * 【两个都不回滚】
 * @see T14_ParentMethodOnTx_TwoChildMethod_RequiresNew
 * 【两个都不回滚】
 * @see T15_ParentMethodOnTx_OneChildMethodThrowExceptionAndNoCached_RequiresNew
 * 【child2回滚】
 * @see T16_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedBySelf_RequiresNew
 * 【两个都不回滚】
 * @see T17_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedByParent_RequiresNew
 * 【child2回滚】
 * @see T18_ParentMethodNoTx_TwoChildMethod_Nested
 * 【两个都不回滚】
 * @see T19_ParentMethodNoTx_OneChildMethodThrowExceptionAndNoCached_Nested
 * 【child2回滚】
 * @see T20_ParentMethodNoTx_OneChildMethodThrowExceptionAndCachedBySelf_Nested
 * 【两个都不回滚】
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

    @Autowired
    T05_ParentMethodOnTx_TwoChildMethodNoException t05_parentMethodOnTx_twoChildMethodNoException;

    @Autowired
    T06_ParentMethodOnTx_OneChildMethodThrowExceptionAndNoCached t06_parentMethodOnTx_oneChildMethodThrowExceptionAndNoCached;

    @Autowired
    T07_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedByParent t07_parentMethodOnTx_oneChildMethodThrowExceptionAndCachedByParent;

    @Autowired
    T08_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedByParent_TwoChildNoTx t08_parentMethodOnTx_oneChildMethodThrowExceptionAndCachedByParent_twoChildNoTx;

    @Autowired
    T09_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedBySelf t09_parentMethodOnTx_oneChildMethodThrowExceptionAndCachedBySelf;

    @Autowired
    T10_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedBySelf_TwoChildNoTx t10_parentMethodOnTx_oneChildMethodThrowExceptionAndCachedBySelf_twoChildNoTx;

    @Autowired
    T11_ParentMethodNoTx_TwoChildMethod_RequiresNew t11_parentMethodNoTx_twoChildMethod_requiresNew;

    @Autowired
    T12_ParentMethodNoTx_OneChildMethodThrowExceptionAndNoCached_RequiresNew t12_parentMethodNoTx_oneChildMethodThrowExceptionAndNoCached_requiresNew;

    @Autowired
    T13_ParentMethodNoTx_OneChildMethodThrowExceptionAndCachedBySelf_RequiresNew t13_parentMethodNoTx_oneChildMethodThrowExceptionAndCachedBySelf_requiresNew;

    @Autowired
    T14_ParentMethodOnTx_TwoChildMethod_RequiresNew t14_parentMethodOnTx_twoChildMethod_requiresNew;

    @Autowired
    T15_ParentMethodOnTx_OneChildMethodThrowExceptionAndNoCached_RequiresNew t15_parentMethodOnTx_oneChildMethodThrowExceptionAndNoCached_requiresNew;

    @Autowired
    T16_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedBySelf_RequiresNew t16_parentMethodNoTx_oneChildMethodThrowExceptionAndCachedBySelf_requiresNew;

    @Autowired
    T17_ParentMethodOnTx_OneChildMethodThrowExceptionAndCachedByParent_RequiresNew t17_parentMethodNoTx_oneChildMethodThrowExceptionAndCachedByParent_requiresNew;

    @Autowired
    T18_ParentMethodNoTx_TwoChildMethod_Nested t18_parentMethodNoTx_twoChildMethod_nested;

    @Autowired
    T19_ParentMethodNoTx_OneChildMethodThrowExceptionAndNoCached_Nested t19_parentMethodNoTx_oneChildMethodThrowExceptionAndNoCached_nested;

    @Autowired
    T20_ParentMethodNoTx_OneChildMethodThrowExceptionAndCachedBySelf_Nested t20_parentMethodNoTx_oneChildMethodThrowExceptionAndCachedBySelf_nested;

    public static void main(String[] args) {
        SpringApplication.run(ServiTXApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        t01_transactional_normal.insert();
//        t02_transactional_rollBack_on_exception.insert();
//        t03_parentMethodNoTx_twoChildMethodNoException.insert();
//        t04_parentMethodNoTx_oneChildMethodThrowException.insert();
//        t05_parentMethodOnTx_twoChildMethodNoException.insert();
//        t06_parentMethodOnTx_oneChildMethodThrowExceptionAndNoCached.insert();
//        t07_parentMethodOnTx_oneChildMethodThrowExceptionAndCachedByParent.insert();
//        t08_parentMethodOnTx_oneChildMethodThrowExceptionAndCachedByParent_twoChildNoTx.insert();
//        t09_parentMethodOnTx_oneChildMethodThrowExceptionAndCachedBySelf.insert();
//        t10_parentMethodOnTx_oneChildMethodThrowExceptionAndCachedBySelf_twoChildNoTx.insert();
//        t11_parentMethodNoTx_twoChildMethod_requiresNew.insert();
//        t12_parentMethodNoTx_oneChildMethodThrowExceptionAndNoCached_requiresNew.insert();
//        t13_parentMethodNoTx_oneChildMethodThrowExceptionAndCachedBySelf_requiresNew.insert();
//        t14_parentMethodOnTx_twoChildMethod_requiresNew.insert();
//        t15_parentMethodOnTx_oneChildMethodThrowExceptionAndNoCached_requiresNew.insert();
//        t16_parentMethodNoTx_oneChildMethodThrowExceptionAndCachedBySelf_requiresNew.insert();
//        t17_parentMethodNoTx_oneChildMethodThrowExceptionAndCachedByParent_requiresNew.insert();
//        t18_parentMethodNoTx_twoChildMethod_nested.insert();
//        t19_parentMethodNoTx_oneChildMethodThrowExceptionAndNoCached_nested.insert();
        t20_parentMethodNoTx_oneChildMethodThrowExceptionAndCachedBySelf_nested.insert();
    }


}
