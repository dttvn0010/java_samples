package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class AsyncTask {

    @Async
    public void run() {
        System.out.println((long)(System.currentTimeMillis()/1000));
        try {
            Thread.sleep(6000);
        }catch(Exception e) {
            e.printStackTrace();
        } 
    }
}
