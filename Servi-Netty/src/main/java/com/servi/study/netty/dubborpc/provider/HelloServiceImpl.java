package com.servi.study.netty.dubborpc.provider;


import com.servi.study.netty.dubborpc.publicinterface.HelloService;

public class HelloServiceImpl implements HelloService {

    //当有消费方调用该方法时， 就返回一个结果
    @Override
    public String hello(String mes) {
        System.out.println("收到客户端消息=" + mes);
        //根据mes 返回不同的结果
        if(mes != null) {
            return mes;
        } else {
            return "你好客户端, 我已经收到你的消息 ";
        }
    }
}
