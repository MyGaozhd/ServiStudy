package com.servi.study.designpatterns._11_prototype;

import com.servi.study.entry.User;

/**
 * 深拷贝
 * 修改 clone 方法 ，将新生成的对象内部字段重新赋值
 */
public class T04_DeepCopy implements Cloneable {
    private int i;
    private String s;
    private User user;

    public T04_DeepCopy() {
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
    protected T04_DeepCopy clone() throws CloneNotSupportedException {
        T04_DeepCopy t04 = (T04_DeepCopy) super.clone();
        t04.setI(6);
        t04.setS("HHH");
        t04.setUser(new User("002", "002"));
        return t04;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        T04_DeepCopy t04 = new T04_DeepCopy();
        t04.setI(5);
        t04.setS("KKK");
        t04.setUser(new User("001", "001"));

        System.out.println(t04.toString());

        T04_DeepCopy clone = t04.clone();

        System.out.println(clone.toString());

        System.out.println(clone.getI());
        System.out.println(clone.getS());
        System.out.println(clone.getUser().getCode());
    }
}
