/**
 * 对比上面一个小程序，分析一下这个程序的输出
 */

package com.servi.study.juc._06;

public class T1 implements Runnable {

	//只能保证有序性和可见性，不能保证原子性
	private volatile int count = 100;
	
	public  void run() {
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void main(String[] args) {
		T1 t = new T1();
		for(int i=0; i<100; i++) {

			new Thread(t, "THREAD" + i).start();
		}
	}
	
}
