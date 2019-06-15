package org.hutao.projectservice.application.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {


    @RabbitListener(queues = "123.ht")
    public void recevice(Object o){

        System.out.println(o.getClass());
        System.out.println(o);
    }

    @RabbitListener(queues = "123.ht")
    public void recevice1(Message o){

        System.out.println(o.getBody());
        System.out.println(o.getMessageProperties());
    }
}
