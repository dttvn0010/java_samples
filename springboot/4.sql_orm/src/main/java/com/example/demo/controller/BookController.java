package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.BookRepository;

@RestController
public class BookController {

    @Autowired private BookRepository bookRepository;
    
    @RequestMapping("/books")
    public ResponseEntity<?> getBooks() {        
        var books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }
}
