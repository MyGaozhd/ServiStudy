package com.servi.study.rpc._01_loadbalance;

/**
 * 带权重的负载均衡
 */
public class T01_WeightRoundRobin {

    // 25%
    private String i_p_0 = "127.0.0.1:80";
    // 25%
    private String i_p_1 = "127.0.0.1:81";
    // 10%
    private String i_p_2 = "127.0.0.1:82";
    //40%
    private String i_p_3 = "127.0.0.1:83";

    public static void main(String[] args) {
        //第一步随机生成一个容量为10,最好是能被权重都整除的数量的ip_port数组
        //根据权重填充各个数组内的IP_port
        //对数组内的数据进行散列，打乱顺序,
        // 类似['i_p_2','i_p_3','i_p_3','i_p_3','i_p_3','i_p_0','i_p_1','i_p_1','i_p_0','i_p_1']
        //定义一个自增的count,买来一个请求count执行+1操作
        //每次操作时用count%10 选取对应的i_p
    }
}
