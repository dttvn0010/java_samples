package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired private BookRepository bookRepository;
    @Autowired MongoTemplate mongoTemplate;
    
    public Optional<Book> getByCode(String code) {
        return bookRepository.findByCode(code);
    }
    
    public long countBooks() {
        return bookRepository.count();
    }
    
    public List<Book> getBooks(int start, int count) {
        var pageable = new OffsetBasedPageable(count, start, Sort.by("id"));
        return bookRepository.findAll(pageable).stream().collect(Collectors.toList());
    }
    
    public List<Book> getByAuthor(String authorName, int start, int count) {
        var pageable = new OffsetBasedPageable(count, start, Sort.by("id"));
        return bookRepository.findByAuthorName(authorName, pageable);
    }
    
    public long countSearch(String keyword) {
        var criteria = new Criteria().orOperator(
                        Criteria.where("name").regex(keyword),
                        Criteria.where("author.name").regex(keyword)
                    );
        
        var query = new Query(criteria);
        return mongoTemplate.count(query, Book.class);
    }
    
    public List<Book> search(String keyword, int start, int count) {
        var pageable = new OffsetBasedPageable(count, start, Sort.by("id"));
        
        var criteria = new Criteria().orOperator(
                        Criteria.where("name").regex(keyword),
                        Criteria.where("author.name").regex(keyword)
                    );
        
        var query = new Query(criteria).with(pageable);        
        return mongoTemplate.find(query, Book.class);
    }

    public void initDatabase() {
        var c1 = new Category();
        c1.code = "C1";
        c1.name = "Category 1";
        
        var c2 = new Category();
        c2.code = "C2";
        c2.name = "Category 2";
        
        var auth1 = new Author();
        auth1.code = "AUTH_001";
        auth1.name = "Author 1";
        
        var auth2 = new Author();
        auth2.code = "AUTH_002";
        auth2.name = "Author 2";
        
        var book1 = new Book();
        book1.code = "B1";
        book1.name = "Book 1";
        book1.author = auth1;
        book1.categories = List.of(c1, c2);
        bookRepository.save(book1);
        
        var book2 = new Book();
        book2.code = "B2";
        book2.name = "Book 2";
        book2.author = auth1;
        book2.categories = List.of(c1);
        bookRepository.save(book2);     
        
        var book3 = new Book();
        book3.code = "B3";
        book3.name = "Book 3";
        book3.author = auth2;
        book3.categories = List.of(c2);
        bookRepository.save(book3);
        
    }
}
