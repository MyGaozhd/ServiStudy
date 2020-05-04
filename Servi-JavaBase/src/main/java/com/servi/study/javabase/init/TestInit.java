package com.servi.study.javabase.init;

import com.servi.study.javabase.gbus.test.GBusTestInterface;
import com.servi.study.log.ServiLogger;
import org.springframework.beans.factory.annotation.Autowired;

public class TestInit extends InitBase {

    @Autowired
    private GBusTestInterface gBusTestInterface;

    private static String a = "TestInit---这是一个静态字段aaaa";
    private String b = "TestInit---这是一个普通字段bbbbbb";

    static {
        ServiLogger.log("TestInit---这是一个static方法-static");
    }

    {
        ServiLogger.log("TestInit---这是一个非static方法");
    }

    public TestInit(String a) {
//        super(a);
        gBusTestInterface.test1("uuuuuuuuuuu", "kkkkkkk");
        ServiLogger.log("TestInit---这是构造方法");
    }

    public static void main(String[] args) {
        new TestInit("");
    }
}
