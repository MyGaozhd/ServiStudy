package com.servi.study.juc._15_AtomicXXX;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * @author servi
 */
public class T06_LongAccumulator {

    public static void main(String[] args) {
        //唯一区别 可自定义 x+y操作 例如改成 x*y
        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0);
        ExecutorService executor = Executors.newFixedThreadPool(8);
        IntStream.range(1, 10).forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(accumulator.getThenReset());
        executor.shutdown();
    }
}
