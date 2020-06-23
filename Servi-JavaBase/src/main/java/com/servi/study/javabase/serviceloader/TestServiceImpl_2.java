package com.servi.study.javabase.serviceloader;

/**
 * @author servi
 * @date 2020/6/23
 */
public class TestServiceImpl_2 implements ITestService {
    @Override
    public void test() {
        System.out.println(this.getClass().getName());
    }
}
