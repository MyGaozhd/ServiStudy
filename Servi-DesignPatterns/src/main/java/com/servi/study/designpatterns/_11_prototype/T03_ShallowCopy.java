package com.servi.study.designpatterns._11_prototype;

import com.servi.study.entry.User;

/**
 * 默认clone方法时浅拷贝。
 * 浅拷贝只拷贝对象本身，对象内部字段仍然指向原始对象内部字段的地址
 */
public class T03_ShallowCopy implements Cloneable {
    private int i;
    private String s;
    private User user;

    public T03_ShallowCopy() {
        System.out.println(" 构造方法 ");
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    protected T03_ShallowCopy clone() throws CloneNotSupportedException {
        return (T03_ShallowCopy) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        T03_ShallowCopy t03_shallowCopy = new T03_ShallowCopy();
        t03_shallowCopy.setI(5);
        t03_shallowCopy.setS("KKK");
        t03_shallowCopy.setUser(new User("001", "001"));

        System.out.println(t03_shallowCopy.toString());

        T03_ShallowCopy clone = t03_shallowCopy.clone();

        System.out.println(clone.toString());

        System.out.println(clone.getI());
        System.out.println(clone.getS());
        System.out.println(clone.getUser().getCode());
    }
}
