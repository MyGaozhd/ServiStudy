/**
 * 锁消除 自动消除StringBuffer内部的锁
 */
package com.servi.study.juc._38_lock_eliminate;

public class T {
    public void add(String s1,String s2){
        StringBuffer buffer = new StringBuffer();
        buffer.append(s1).append(s2);
    }
}
