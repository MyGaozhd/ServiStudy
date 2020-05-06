package com.servi.study.designpatterns._11_prototype;

import com.servi.study.entry.User;

/**
 * 有 final 关键字修饰的字段时，只能使用浅拷贝
 */
public class T05_DeepCopy_Final implements Cloneable {
    private int i;
    private String s;
    private User user;
    private final User user1 = new User();

    public T05_DeepCopy_Final() {
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
    protected T05_DeepCopy_Final clone() throws CloneNotSupportedException {
        T05_DeepCopy_Final t04 = (T05_DeepCopy_Final) super.clone();
        t04.setI(6);
        t04.setS("HHH");
        t04.setUser(new User("002", "002"));
        /**
         * final关键字 报错
         */
        // t04.user1=new User();
        return t04;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        T05_DeepCopy_Final t04 = new T05_DeepCopy_Final();
        t04.setI(5);
        t04.setS("KKK");
        t04.setUser(new User("001", "001"));

        System.out.println(t04.toString());

        T05_DeepCopy_Final clone = t04.clone();

        System.out.println(clone.toString());

        System.out.println(clone.getI());
        System.out.println(clone.getS());
        System.out.println(clone.getUser().getCode());
    }
}
