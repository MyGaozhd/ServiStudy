package com.servi.study.juc._36_threadpool_more;

import java.util.concurrent.Callable;

public interface CrossesRunnable  extends Callable {
public void beforeRun();

    public void afterRun();
}
