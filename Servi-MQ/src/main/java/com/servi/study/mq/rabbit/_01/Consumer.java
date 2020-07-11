package com.servi.study.mq.rabbit._01;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = "routingkey_demo";
    private static final String QUEUE_NAME = "queue_demo";

    private static final String IP = "10.6.195.250";
    private static final int port = 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Address[] addresses = new Address[]{new Address(IP, port)};

        ConnectionFactory factory = new ConnectionFactory();

        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection(addresses);


        final Channel channel = connection.createChannel();
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

        channel.basicConsume(QUEUE_NAME, consumer);
        TimeUnit.SECONDS.sleep(5);

        channel.close();
        connection.close();

    }
}
