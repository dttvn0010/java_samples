package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    
    @PersistenceContext private EntityManager em;
    
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
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(Long.class);
        var book = cq.from(Book.class);
        var author = book.join("author");
        
        cq.multiselect(cb.count(book))
          .where(
             cb.or(
               cb.like(book.get("name"), "%" + keyword + "%"),
               cb.like(author.get("name"), "%" + keyword + "%")
             )
          );
        
        
        var query = em.createQuery(cq);
        return query.getSingleResult();
    }
    
    public List<Book> search(String keyword, int start, int count) {
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(Book.class);
        var book = cq.from(Book.class);
        var author = book.join("author");
        
        cq.select(book)
          .where(
             cb.or(
               cb.like(book.get("name"), "%" + keyword + "%"),
               cb.like(author.get("name"), "%" + keyword + "%")
             )
          );
        
        
        var query = em.createQuery(cq);
        query.setFirstResult(start);
        query.setMaxResults(count);
        return query.getResultList();
    }
    
    @Transactional 
    public void addBooks() {
        for(int i = 0; i < 10; i++) {
            var book = new Book();
            book.code = "B2";
            book.name = "Book 2";
            var auth = new Author();
            auth.id = 1;
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
        
        var auth1 = new Author();
        auth1.code = "AUTH_001";
        auth1.name = "Author 1";
        authorRepository.save(auth1);
        
        var auth2 = new Author();
        auth2.code = "AUTH_002";
        auth2.name = "Author 2";
        authorRepository.save(auth2);
        
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
