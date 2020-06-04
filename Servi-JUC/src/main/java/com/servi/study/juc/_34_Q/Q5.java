package com.servi.study.juc._34_Q;

/**
 * @author servi
 * @date 2020/6/4
 */
public class Q5 {

    private BaseDao dao = null;

    private BaseDao getBaseDao(){
        if (dao==null){
            dao = new BaseDao();
        }
        return dao;
    }

    public void query(){
        getBaseDao().hashCode();
    }

    static class BaseDao{

    }
}
