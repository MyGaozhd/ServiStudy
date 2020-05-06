package com.servi.study.designpatterns._11_prototype;

/**
 * 原型模式如果不实现Cloneable接口，在调用clone()方法时，抛出CloneNotSupportedException
 */
public class T02 {

    private int i;

    public void setI(int i) {
        this.i = i;
    }

    @Override
    protected T02 clone() throws CloneNotSupportedException {
        return (T02) super.clone();
    }

    public static void main(String[] args) {

        T02 t1 = new T02();
        t1.setI(5);

        try {
            T02 clone = t1.clone();
            System.out.println(clone.i);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            //抛出异常
        }
    }
}
