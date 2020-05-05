package com.servi.study.mq.rabbit.oneExMuiltQueue;

import com.rabbitmq.client.*;
import com.servi.study.mq.rabbit.channel.IChannel;
import com.servi.study.mq.rabbit.connect.IConnect;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConsumerOneExMuiltQueue {


    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        final Channel channel = IChannel.getInstance().createChannel();
        channel.basicQos(64);

        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                System.out.println("consumer:" + new String(body));

                try {
//                    Thread.sleep(1000);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        channel.basicConsume("queue1_1", consumer);
        channel.basicConsume("queue1_2", consumer);
        channel.basicConsume("queue2_1", consumer);
        channel.basicConsume("queue2_2", consumer);
        TimeUnit.SECONDS.sleep(5);

        channel.close();
        IConnect.getInstance().getConnection().close();
    }
}
