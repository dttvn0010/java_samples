package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@RestController
public class BookController {

    @Autowired private BookRepository bookRepository;
    @Autowired private BookService bookService;
    
    @RequestMapping("/books")
    public ResponseEntity<?> getBooks() {        
        var books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }
    
    @RequestMapping("/find_books_by_author")
    public ResponseEntity<?> getBooksByAuthor(@RequestParam("author") String author) {
        var books = bookService.getByAuthor(author);
        return ResponseEntity.ok(books);
    }
}
