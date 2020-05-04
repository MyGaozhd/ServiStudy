package com.servi.study.javabase.gbus.test;


import com.servi.study.javabase.gbus.IResponseAdapter;

public class GBusTestResponse implements IResponseAdapter {
    @Override
    public <T, R> T getResponse(R r) {
        return (T) r;
    }
}
