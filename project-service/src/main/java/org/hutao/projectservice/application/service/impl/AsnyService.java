package org.hutao.projectservice.application.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsnyService {


    @Async
    public String hello(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("赈灾");
        String s = "我是OK的";
        return s;
    }
}
