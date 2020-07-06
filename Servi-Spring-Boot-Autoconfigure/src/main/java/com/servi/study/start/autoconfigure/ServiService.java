package com.servi.study.start.autoconfigure;

public class ServiService {

    private ServiProperties properties;

    public ServiService(ServiProperties properties) {
        this.properties = properties;
    }

    public void log(String log) {

        System.out.println(properties.getPrefix() + log + properties.getSuffix());
    }
}
