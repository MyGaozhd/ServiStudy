/**
 * volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
 *
 * t = new T02_VolatileReference1(false); 不行是因为 running 变量已经被加载到cpu,此时 t变化，不会通知cpu重新获取running,
 *  因为 running 不是 volatile
 *
 *  t = null; 也不行与上面同理
 */
package com.servi.study.juc._12_Volatile;

import java.util.concurrent.TimeUnit;

public class T02_VolatileReference1 {

    boolean running = true;

    volatile static T02_VolatileReference1 t = new T02_VolatileReference1(true);

    public  T02_VolatileReference1 (boolean running) {
        this.running = running;
    }

    void m() {
        System.out.println("m start");
        while(running) {
			/*
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;

        // 测试 然后看现象
//        t = new T02_VolatileReference1(false);
//        t = null;
    }
}
