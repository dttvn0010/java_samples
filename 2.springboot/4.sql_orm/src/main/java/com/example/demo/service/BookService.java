package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;

@Service
public class BookService {
    
    @Autowired private BookRepository bookRepository;
    @Autowired private AuthorRepository authorRepository;
    @Autowired private CategoryRepository categoryRepository;
    
    public long countBooks() {
        return bookRepository.count();
    }
    
    @Transactional 
    public void addBooks() {
        for(int i = 0; i < 10; i++) {
            var book = new Book();
            book.code = "B2";
            book.name = "Book 2";
            var auth = new Author();
            auth.id = 3;
            book.author = auth;
            bookRepository.save(book);
        }
    }

    @Transactional
    public void initDatabase() {
        var c1 = new Category();
        c1.code = "C1";
        c1.name = "Category 1";
        categoryRepository.save(c1);
        
        var c2 = new Category();
        c2.code = "C2";
        c2.name = "Category 2";
        categoryRepository.save(c2);
        
        var auth = new Author();
        auth.code = "AUTH_001";
        auth.name = "Author 1";
        authorRepository.save(auth);
        
        var book1 = new Book();
        book1.code = "B1";
        book1.name = "Book 1";
        book1.author = auth;
        book1.categories = List.of(c1, c2);
        bookRepository.save(book1);
        
        var book2 = new Book();
        book2.code = "B2";
        book2.name = "Book 2";
        book2.author = auth;
        book2.categories = List.of(c1);
        bookRepository.save(book2);       
        
    }
}
