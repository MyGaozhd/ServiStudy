package com.servi.study.juc._36_threadpool_more;

public class DBRunnable implements CrossesRunnable {

    @Override
    public void beforeRun() {

    }

    @Override
    public void afterRun() {

    }

    @Override
    public Object call() throws Exception {
        this.beforeRun();
        return null;
    }
}
