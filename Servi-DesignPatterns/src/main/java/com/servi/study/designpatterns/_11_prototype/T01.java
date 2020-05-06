package com.servi.study.designpatterns._11_prototype;

/**
 * Cloneable 是一个标识接口，并没有抽象方法，用来告诉jvm此对象可以被拷贝。
 */
public class T01 implements Cloneable {

    private int i;

    public T01(){
        System.out.println("构造方法");
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    protected T01 clone() throws CloneNotSupportedException {
        return (T01) super.clone();
    }

    public static void main(String[] args) {

        T01 t1 = new T01();
        t1.setI(5);

        try {
            T01 clone = t1.clone();
            System.out.println(clone.i);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
