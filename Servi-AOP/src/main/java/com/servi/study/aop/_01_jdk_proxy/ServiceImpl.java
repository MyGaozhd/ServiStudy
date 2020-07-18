package com.servi.study.aop._01_jdk_proxy;

/**
 * @author servi
 * @date 2020/7/18
 */
public class ServiceImpl implements IService {
    @Override
    public int add(int i, int j) {
        return i + j;
    }
}
