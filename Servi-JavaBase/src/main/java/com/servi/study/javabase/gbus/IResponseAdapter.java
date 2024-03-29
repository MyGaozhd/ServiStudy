package com.servi.study.javabase.gbus;

public interface IResponseAdapter {

    public <T, R> T getResponse(R r);

    public static class DefaultResponseAdapter implements IResponseAdapter {
        @Override
        public <T, R> T getResponse(R r) {
            return (T) r;
        }
    }
}
