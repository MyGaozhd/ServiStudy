package com.servi.study.juc._15_AtomicXXX;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author servi
 * @see [io.netty.channel.ChannelOutboundBuffer]
 * AtomicIntegerFieldUpdater 定义成static能够节省字节数量
 * 代替 AtomicLong 操作类，节省字节
 */
public class T05_AtomicReferenceFieldUpdater {

    public static void main(String[] args) {

        AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(T.class, String.class, "a");

        T t = new T();
        t.a = "a";
        System.out.println(updater.compareAndSet(t, "a", "b"));
        System.out.println(t.a);

    }

    static class T {
        volatile String a;
    }
}
