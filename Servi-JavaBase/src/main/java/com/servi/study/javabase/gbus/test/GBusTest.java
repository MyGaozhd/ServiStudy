package com.servi.study.javabase.gbus.test;

import com.servi.study.javabase.gbus.GBusRouter;
import com.servi.study.log.ServiLogger;

public class GBusTest implements IGBusTest {
    public static void main(String[] args) {
//        String a = GBusRouter.operate(GBusTestInterface.class).test("a", "b");
//        ServiLogger.log(a);

        String b = GBusRouter.operate(GBusTestInterface.class).test1("a", "b");
        ServiLogger.log(b);
//
//        String c = GBusRouter.operate(GBusTestInterface.class).test2("a", "b");
//        ServiLogger.log(c);
    }

    @Override
    public String test(String a, String b) {
        ServiLogger.log(a + b);
        return a + b;
    }
}
