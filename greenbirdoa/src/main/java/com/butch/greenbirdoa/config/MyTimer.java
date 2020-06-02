package com.butch.greenbirdoa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 用于异步监听的定时器.
 * 
 * 目前主要用于签到的监听
 */
@Configuration      //标记配置类,会被spring注入
@EnableScheduling   //打开定时器功能
@EnableAsync        //定时器设置为异步执行
public class MyTimer {

    //每天的23点59分59秒执行一次
    @Scheduled(cron = "59 59 23  *  *  ?")
    public void checkSigin(){
        System.out.println("异步定时器执行...");   

    }


}