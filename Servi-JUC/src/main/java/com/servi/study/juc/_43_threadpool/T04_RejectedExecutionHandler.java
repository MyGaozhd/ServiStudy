/**
 * 第一种拒绝策略是 AbortPolicy，这种拒绝策略在拒绝任务时，会直接抛出一个类型为 RejectedExecutionException 的 RuntimeException，让你感知到任务被拒绝了，于是你便可以根据业务逻辑选择重试或者放弃提交等策略。
 * 第二种拒绝策略是 DiscardPolicy，这种拒绝策略正如它的名字所描述的一样，当新任务被提交后直接被丢弃掉，也不会给你任何的通知，相对而言存在一定的风险，因为我们提交的时候根本不知道这个任务会被丢弃，可能造成数据丢失。
 * 第三种拒绝策略是 DiscardOldestPolicy，如果线程池没被关闭且没有能力执行，则会丢弃任务队列中的头结点，通常是存活时间最长的任务，这种策略与第二种不同之处在于它丢弃的不是最新提交的，而是队列中存活时间最长的，这样就可以腾出空间给新提交的任务，但同理它也存在一定的数据丢失风险。
 * 第四种拒绝策略是 CallerRunsPolicy，相对而言它就比较完善了，当有新任务提交后，如果线程池没被关闭且没有能力执行，则把这个任务交于提交任务的线程执行，也就是谁提交任务，谁就负责执行任务。这样做主要有两点好处。
 * 第一点新提交的任务不会被丢弃，这样也就不会造成业务损失。
 * 第二点好处是，由于谁提交任务谁就要负责执行任务，这样提交任务的线程就得负责执行任务，而执行任务又是比较耗时的，在这段期间，提交任务的线程被占用，也就不会再提交新的任务，减缓了任务提交的速度，相当于是一个负反馈。在此期间，线程池中的线程也可以充分利用这段时间来执行掉一部分任务，腾出一定的空间，相当于是给了线程池一定的缓冲期。
 */
package com.servi.study.juc._43_threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * --发生拒绝的场景--
 * 第一种情况是当我们调用 shutdown 等方法关闭线程池后，即便此时可能线程池内部依然有没执行完的任务正在执行，
 * 但是由于线程池已经关闭，此时如果再向线程池内提交任务，就会遭到拒绝。
 * 第二种情况是线程池没有能力继续处理新提交的任务，也就是工作已经非常饱和的时候。
 */
public class T04_RejectedExecutionHandler {

    public static void main(String[] args) {

        /**
         * 一：AbortPolicy
         *           会直接抛出一个类型为 RejectedExecutionException 的 RuntimeException，
         *           让你感知到任务被拒绝了，于是你便可以根据业务逻辑选择重试或者放弃提交等策略。
         */
        RejectedExecutionHandler rejectedExecutionHandler1 = new ThreadPoolExecutor.AbortPolicy();
        /**
         * 二、DiscardPolicy
         *     当新任务被提交后直接被丢弃掉，也不会给你任何的通知，相对而言存在一定的风险，
         *     因为我们提交的时候根本不知道这个任务会被丢弃，可能造成数据丢失。
         */
        RejectedExecutionHandler rejectedExecutionHandler2 = new ThreadPoolExecutor.DiscardOldestPolicy();
        /**
         * 三、DiscardOldestPolicy
         *    如果线程池没被关闭且没有能力执行，则会丢弃任务队列中的头结点，通常是存活时间最长的任务，
         *    这种策略与第二种不同之处在于它丢弃的不是最新提交的，而是队列中存活时间最长的，这样就可以腾出空间给新提交的任务，
         *    但同理它也存在一定的数据丢失风险。
         */
        RejectedExecutionHandler rejectedExecutionHandler3 = new ThreadPoolExecutor.DiscardOldestPolicy();
        /**
         * 四、CallerRunsPolicy
         *     相对而言它就比较完善了，当有新任务提交后，如果线程池没被关闭且没有能力执行，则把这个任务交于提交任务的线程执行，也就是谁提交任务，
         *     谁就负责执行任务。这样做主要有两点好处。
         *     第一点新提交的任务不会被丢弃，这样也就不会造成业务损失。
         *     第二点好处是，由于谁提交任务谁就要负责执行任务，这样提交任务的线程就得负责执行任务，
         *     而执行任务又是比较耗时的，在这段期间，提交任务的线程被占用，也就不会再提交新的任务，减缓了任务提交的速度，相当于是一个负反馈。
         *     在此期间，线程池中的线程也可以充分利用这段时间来执行掉一部分任务，腾出一定的空间，相当于是给了线程池一定的缓冲期。
         */
        RejectedExecutionHandler rejectedExecutionHandler4 = new ThreadPoolExecutor.CallerRunsPolicy();

        //推荐自定义
    }
}
