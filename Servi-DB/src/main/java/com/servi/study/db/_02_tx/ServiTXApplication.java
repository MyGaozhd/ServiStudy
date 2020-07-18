package com.servi.study.db._02_tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ServiTXApplication implements CommandLineRunner {

    @Autowired
    T01_Transactional_Normal t01_transactional_normal;

    @Autowired
    T02_Transactional_RollBack_On_Exception t02_transactional_rollBack_on_exception;

    public static void main(String[] args) {
        SpringApplication.run(ServiTXApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        t01_transactional_normal();
        t02_transactional_rollBack_on_exception();

    }

    public void t01_transactional_normal() {
        t01_transactional_normal.insert();
    }

    public void t02_transactional_rollBack_on_exception() {
        t02_transactional_rollBack_on_exception.insert();
    }
}
