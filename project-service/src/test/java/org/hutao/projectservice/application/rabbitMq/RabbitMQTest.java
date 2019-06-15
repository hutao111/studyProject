package org.hutao.projectservice.application.rabbitMq;


import org.hutao.projectapi.domain.DocumentClassify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;


    // 点对点发送消息
    @Test
    public void send() {
        DocumentClassify classify = new DocumentClassify();
        classify.setCode(123);
        classify.setName("涛哥最帅");
        Map map = new HashMap();
        map.put("msg","第一个消息");
        map.put("data", Arrays.asList("3",1,true));

        rabbitTemplate.convertAndSend("hutao-direct", "xyy.ht", classify);
    }

    @Test
    @RabbitListener
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("xyy.ht");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    // 订阅发送消息
    @Test
    public void sendTopic() {
        DocumentClassify classify = new DocumentClassify();
        classify.setCode(123);
        classify.setName("涛哥最帅");
        Map map = new HashMap();
        map.put("msg","第一个消息");
        map.put("data", Arrays.asList("3",1,true));

        rabbitTemplate.convertAndSend("hutao-topic", "123", classify);
    }
}
