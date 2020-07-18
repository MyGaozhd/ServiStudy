package com.servi.study.aop._00_target;

import com.servi.study.aop._00_target.IService;

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
