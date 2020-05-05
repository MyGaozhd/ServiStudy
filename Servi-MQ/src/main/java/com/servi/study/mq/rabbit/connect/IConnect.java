package com.servi.study.mq.rabbit.connect;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class IConnect {

    private static IConnect INSTANCE = new IConnect();

    private static final String IP = "127.0.0.1";
    private static final int port = 5672;
    private Connection connection = null;

    private IConnect() {
    }

    public static IConnect getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {

        if (connection == null) {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(IP);
            factory.setPort(port);
            factory.setUsername("servi");
            factory.setPassword("servi");

            try {
                connection = factory.newConnection();
            } catch (Exception e) {
            }
        }
        return connection;
    }
}
