package com.servi.study.juc._42_segment_lock;

/**
 * lock String -> lock Object
 * 分段锁
 * <p>
 * thread1->11
 * thread1->start->http://aaa
 * thread2->11
 * thread1->end->http://aaa
 * thread2->start->http://aaa
 * thread2->end->http://aaa
 */
public class T01_SegmentLock {

    private static Object[] segs = new Object[12];

    static {
        for (int i = 0; i < 12; i++) {
            segs[i] = new Object();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String url = "http://aaa";

        Thread thread1 = new SegThread("thread1", url);
        Thread thread2 = new SegThread("thread2", url);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }

    public static void lock(Object lock) throws InterruptedException {

        synchronized (lock) {
            Thread.sleep(5000);
            System.out.println(lock.toString());
        }
    }

    static class SegThread extends Thread {
        private String url;

        public SegThread(String name, String url) {
            super(name);
            this.url = url;
        }

        @Override
        public void run() {
            int hash = hash(url.hashCode());

            System.out.println(getName() + "->" + hash + "->" + ((12 - 1) & hash));
            int seg = (12 - 1) & hash;
            Object lock = segs[seg];

            synchronized (lock) {
                System.out.println(getName() + "->start->" + url);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "->end->" + url);
            }
        }

        final int hash(Object key) {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }
    }
}
