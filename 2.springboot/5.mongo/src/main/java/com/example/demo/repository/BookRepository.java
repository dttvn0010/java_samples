package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Book;

public interface BookRepository extends MongoRepository<Book, ObjectId> {
    
    Optional<Book> findByCode(String code);
    List<Book> findByAuthorName(String authorName, Pageable pageable);
}
