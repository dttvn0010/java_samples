package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    
    @Autowired
    private AsyncTask asyncTask;

    @Scheduled(fixedRate = 3000)
    public void run() {
        asyncTask.run();
    }
}
