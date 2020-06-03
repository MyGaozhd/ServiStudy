/**
 *
 */
package com.servi.study.juc._37_sync_principle;

import org.openjdk.jol.info.ClassLayout;

public class T02 {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o ).toPrintable());

        System.out.println("==============================================");
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o ).toPrintable());
        }
    }
}
