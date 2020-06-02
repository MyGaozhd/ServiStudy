/**
 * volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
 *  原因，执行完x的赋值之后，其他线程很快将 data.b值改变。所以x,y不相等
 *  int x = data.a;
 *  int y = data.b;
 *
 *  思考？ x>y 有可能吗？
 *  不可能，因为volatile保证有序性，int x = data.a;int y = data.b; 永远不会出现指令重排序。
 *  不会先执行y的赋值在执行x的赋值
 */
package com.servi.study.juc._12_Volatile;

public class T03_VolatileReference3 {

    private static class Data {
        int a, b;

        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    volatile static Data data;

    public static void main(String[] args) {
        Thread writer = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                data = new Data(i, i);
            }
        });

        Thread reader = new Thread(()->{
            while (data == null) {

            }
            int x = data.a;
            int y = data.b;
            if(x != y) {
                System.out.printf("a = %s, b=%s%n", x, y);
            }
        });

        reader.start();
        writer.start();

        try {
            reader.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }
}
