package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BookService;

@RestController
public class BookController {
    
    @Autowired private BookService bookService;
    
    @RequestMapping("/get_book_by_code")
    public ResponseEntity<?> getBookByCode(@RequestParam("code") String code) {
        var book = bookService.getByCode(code);
        return ResponseEntity.of(book);
    }
    
    @RequestMapping("/books")
    public ResponseEntity<?> getBooks(@RequestParam("start") int start, @RequestParam("count") int count) {        
        var books = bookService.getBooks(start, count);
        return ResponseEntity.ok(books);
    }
    
    @RequestMapping("/get_books_by_author")
    public ResponseEntity<?> getBooksByAuthor(@RequestParam("author") String author, 
                                                @RequestParam("start") int start, 
                                                @RequestParam("count") int count) {
        var books = bookService.getByAuthor(author, start, count);
        return ResponseEntity.ok(books);
    }
    
    @RequestMapping("/count_books")
    @ResponseBody
    public long countBooks(@RequestParam("keyword") String keyword) {
        return bookService.countSearch(keyword);
    }
    
    @RequestMapping("/search_books")
    public ResponseEntity<?> searchBooks(@RequestParam("keyword") String keyword,
                                        @RequestParam("start") int start, 
                                        @RequestParam("count") int count){
        var books = bookService.search(keyword, start, count);
        return ResponseEntity.ok(books);
    }
}
