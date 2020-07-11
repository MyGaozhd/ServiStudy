package com.servi.study.mq.rabbit._01.channel;

import com.rabbitmq.client.Channel;
import com.servi.study.mq.rabbit._01.connect.IConnect;

import java.io.IOException;

public class IChannel {

    private static IChannel INSTANCE = new IChannel();

    private IChannel() {
    }

    public static IChannel getInstance() {
        return INSTANCE;
    }

    public Channel createChannel() {

        try {
            return IConnect.getInstance().getConnection().createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
