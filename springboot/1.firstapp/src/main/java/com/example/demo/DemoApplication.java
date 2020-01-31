package com.example.demo;

import javax.annotation.Nonnull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    void test1(@Nonnull String s) {
        
    }
    
    void test2(String s) {
        //test1(s);
    }
    
    void test3() {
        test2(null);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
