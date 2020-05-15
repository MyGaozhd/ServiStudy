package com.servi.study.javabase.hook;

/**
 * java 结束时 回调方法
 */
public class ShutDownHook {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println(" shut down ")));

//        try {
////            Thread.sleep(1111111111);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
