package com.servi.study.jvm.method;

/**
 * private 方法 和 public方法生成的字节码 acc_flag不同。用来表示方法的可见性
 *
 * 具体字节码，暂时没有找办法看到
 */
public class T {

    private String s;

    private String getS(){
        return s + "123";
    }

    public static void main(String[] args) {
        new T().getS();
    }
}
