package com.servi.study.javabase.gbus.test;

import com.servi.study.javabase.gbus.annotation.GBusInterface;
import com.servi.study.javabase.gbus.annotation.GBusMethod;

@GBusInterface(clazz = IGBusTest.class)
public interface GBusTestInterface {

    @GBusMethod(clazz = IGBusTest.class)
    public String test(String a, String b);

    @GBusMethod(method = "test", requestAdapter = GBusTestRequest.class, responseAdapter = GBusTestResponse.class)
    public String test1(String a, String b);

    @GBusMethod(method = "test", autoParameterType = false, parameterTypes = {String.class, String.class})
    public String test2(String a, String b);
}

