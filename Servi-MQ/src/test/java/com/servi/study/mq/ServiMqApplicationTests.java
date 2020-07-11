package com.servi.study.mq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.event.TransactionalEventListener;

@SpringBootTest
class ServiMqApplicationTests {

    @Autowired
    RabbitTemplate template;

    @Test
    void contextLoads() {
        template.convertAndSend("123");
    }

    @Test
    void receive() {
        Message msg = template.receive();
        System.out.println(msg);
    }
}
