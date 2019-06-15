package org.hutao.projectservice.application.service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SchedulService {

//    @Scheduled(cron ="5-10 * * * * ? " )
    public void schedul(){

        System.out.println("定时任务开始啦！"+"执行的时间为："+new Date().toLocaleString());
    }
}
