package com.servi.study.javabase.gbus.test;


import com.servi.study.javabase.gbus.IRequestAdapter;

public class GBusTestRequest implements IRequestAdapter {
    @Override
    public Object[] getParam(Object[] args) {
        return args;
    }
}
