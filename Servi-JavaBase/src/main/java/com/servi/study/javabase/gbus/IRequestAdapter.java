package com.servi.study.javabase.gbus;

public interface IRequestAdapter {

    public Object[] getParam(Object[] args);

    public static class DefaultRequestAdapter implements IRequestAdapter {

        @Override
        public Object[] getParam(Object[] args) {
            return args;
        }
    }
}
