package com.servi.study.redis._00_200W_data;

import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * CONFIG SET protected-mode no
 */
public class T01_200W_Data {
    //连接本地的 Redis 服务
    Jedis jedis = null;

    public T01_200W_Data() {
        jedis = new Jedis("10.16.3.116", 6379);
//        jedis.auth("123456");
    }

    public void set(String name) {
        String key = "global:lock:lock_de_idx_service:" + name;
        for (int i = 0; i < 2000000; i++) {
            jedis.set(key + i, i + "");
        }
    }

    public void reset(String name) {
        String key = "global:lock:lock_de_idx_service:" + name;
        for (int i = 0; i < 2000000; i++) {
            jedis.expireAt(key + i, 0);
        }
    }

    public void clear(String name) {
        String key = "global:lock:lock_de_idx_service:" + name;
        for (int i = 0; i < 2000000; i++) {
            jedis.del(key + i);
        }
    }

    public static void main(String[] args) {

        T01_200W_Data t = new T01_200W_Data();
//        String name = UUID.randomUUID().toString();
////
//        long start1 = System.currentTimeMillis();
//        t.set(name);
//        long start2 = System.currentTimeMillis();
//        t.reset(name);
//        long start3 = System.currentTimeMillis();
//        System.out.println(" start1 = " + start1 + " start2 = " + start2 + " start3 = " + start3);

//        long start3 = System.currentTimeMillis();
//        t.set(name);//
//        long start4 = System.currentTimeMillis();
//        t.clear(name);
//        long start5 = System.currentTimeMillis();
//
//       System.out.println(" start3 = " + start3 + " start4 = " + start4 + " start5 = " + start5);

    }
}
