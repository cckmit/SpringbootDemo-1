package com.example.springbootdemo.scheduled.servicer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-demo
 * @description:
 * @author: swd
 * @create: 2020-07-14
 **/
@Slf4j
@Service
public class SendMessage implements YjxJobBase{


    @Override
    @Async
    public void execute(String data) throws Exception {
        log.info(data);
    }

    @Service
    private class stockRunOutWarn implements YjxJobBase{

        //@Scheduled(cron = "0/10 * * * * ? ")
        public void sendMessage1(){
            try {
                this.execute(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void execute(String data) throws Exception {
            System.out.println(data+"sendMessage --- 1 推送了一条消息"+ Thread.currentThread().getName());
        }
    }


}
