package com.servi.study.mq.rabbit.oneExMuiltQueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.servi.rabbit.channel.IChannel;
import com.servi.rabbit.connect.IConnect;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class OneExMuiltQueue {
    public static void main(String[] args) throws IOException, TimeoutException {

        Channel channel = IChannel.getInstance().createChannel();

        //同一个通道下面设置两个交换机
        channel.exchangeDeclare("ex1", "direct", true);
        channel.exchangeDeclare("ex2", "direct", true);

        //给每个交换机设置 两个队列
        channel.queueDeclare("queue1_1", true, false, false, null);
        channel.queueDeclare("queue1_2", true, false, false, null);
        channel.queueDeclare("queue2_1", true, false, false, null);
        channel.queueDeclare("queue2_2", true, false, false, null);

        //每个 ex1交换机绑定两个队列
        channel.queueBind("queue1_1", "ex1", "routingkey1_1");
        channel.queueBind("queue1_2", "ex1", "routingkey1_2");

        //每个 ex2交换机绑定两个队列
        channel.queueBind("queue2_1", "ex2", "routingkey2_1");
        channel.queueBind("queue2_2", "ex2", "routingkey2_2");

        channel.basicPublish("ex1", "routingkey1_1", MessageProperties.PERSISTENT_TEXT_PLAIN, "routingkey1_1".getBytes());
        channel.basicPublish("ex1", "routingkey1_2", MessageProperties.PERSISTENT_TEXT_PLAIN, "routingkey1_2".getBytes());

        channel.basicPublish("ex2", "routingkey2_1", MessageProperties.PERSISTENT_TEXT_PLAIN, "routingkey2_1".getBytes());
        channel.basicPublish("ex2", "routingkey2_2", MessageProperties.PERSISTENT_TEXT_PLAIN, "routingkey2_2".getBytes());

        channel.close();

        IConnect.getInstance().getConnection().close();
    }
}
