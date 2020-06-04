/**
 * synchronized关键字
 */
package com.servi.study.juc._04;

public class T {

	private static int count = 10;
	
	public synchronized static void m() { //这里等同于synchronized(T.class)
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void mm() {
		synchronized(T.class) { //考虑一下这里写synchronized(this)是否可以？ 不可以
			count --;
		}
	}

}
