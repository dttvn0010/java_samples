package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.BookService;

@SpringBootApplication
public class App {
    
	public static void main(String[] args) {
		var context = SpringApplication.run(App.class, args);
		var bookService = context.getBean(BookService.class);
		if(bookService.countBooks() == 0) {
		    bookService.initDatabase();
		}
		System.out.println("Done!");
	}

}
