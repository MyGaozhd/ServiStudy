package com.servi.study.juc._14_MoreSync;

/**
 * @author servi
 * @date 2020/6/23
 * 测试 String 锁
 * @see [com.yonyou.cloud.middleware.rpc.RestRPCInvoker->com.yonyou.cloud.middleware.iris.loadbalancer.factory.RibbonFactory]
 * <p>
 * 降低锁竞争情况，根据传过来的又能确保全局唯一的值作为锁
 * 将String 作为参数传递。不过此时应尽量保证String的内容足够特指，具有唯一性。不容易被其他业务使用
 */
public class AvailableLockString {

    public void m1(String lock) {
        synchronized (lock) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m1");
        }
    }

    public void m2(String lock) {
        synchronized (lock) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m2");
        }
    }

    public static void main(String[] args) {
        //用于全局锁的字符串
        String lock = "LOCK";
        AvailableLockString t = new AvailableLockString();
        new Thread(() -> {
            t.m1(lock);
        }).start();
        new Thread(() -> {
            t.m2(lock);
        }).start();
    }
}
