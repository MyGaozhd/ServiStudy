package com.servi.study.mq.rabbit._01.exchange;

import com.rabbitmq.client.Channel;

public class IExChange {

    private static IExChange INSTANCE = new IExChange();
    private Channel channel;

    private IExChange() {
    }

    public static IExChange getInstance() {
        return INSTANCE;
    }

    public IExChange createEx() {

        return null;
    }
}
