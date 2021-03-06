/**
 * 对比上面一个小程序，分析一下这个程序的输出
 */

package com.servi.study.juc._06;

public class T implements Runnable {

	private int count = 100;
	
	public synchronized void run() { 
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void main(String[] args) {
		T t = new T();
		for(int i=0; i<100; i++) {

			new Thread(t, "THREAD" + i).start();
		}
	}
	
}
