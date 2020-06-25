package com.servi.study.spring.geek._09_spring_resource.springx;


import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * 简单地继承 {@link sun.net.www.protocol.x.Handler} 类
 *
 * @author servi
 * @see sun.net.www.protocol.x.Handler
 * 协议的名称是 根据 包名 com.servi.study.spring.geek._09_spring_resource.springx来确定的。
 * springx 就是协议的名称。就是 handler 的包的最后一级
 */
public class Handler extends sun.net.www.protocol.x.Handler {

    // -Djava.protocol.handler.pkgs=com.servi.study.spring.geek._09_spring_resource
    public static void main(String[] args) throws IOException {
        // springx 协议
        URL url = new URL("springx:spring_resource\\production.properties"); // 类似于 classpath:spring_resource\production.properties
        InputStream inputStream = url.openStream();
        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("UTF-8")));
    }
}
