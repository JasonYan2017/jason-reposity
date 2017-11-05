package com.JasonYan.project.first.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 说明:
 *
 * @author jasonyan
 * @create 2017-10-29 16:01
 */
@Service
public class Task_1 {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "0 0/10 * * * ?")
    @Async("myAsync")
    public void myTask_1() throws ParseException {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SS");
        String ss = sdf.format(d);
        LOGGER.info("每1s执行一次====="+ss);
    }

    public String show(){
        LOGGER.info("容器已经注入对象");
        return "Success";
    }

    @Scheduled(cron = "0 0/20 * * * ?")
    @Async("myAsync")
    public void myTask_2() throws ParseException {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SS");
        String ss = sdf.format(d);
        LOGGER.info("每2s执行一次====="+ss);
    }

    @Scheduled(cron = "0 0/30 * * * ?")
    @Async("myAsync")
    public void myTask_3() throws ParseException {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SS");
        String ss = sdf.format(d);
        LOGGER.info("每3s执行一次====="+ss);

    }
}

