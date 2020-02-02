package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {

    @Id @GeneratedValue 
    public int id;
    
    @Column
    public String code;
    
    @Column
    public String name;
    
    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    public Author author;
    
    @ManyToMany
    @JoinTable(
      name = "book_category", 
      joinColumns = @JoinColumn(name = "book_id"), 
      inverseJoinColumns = @JoinColumn(name = "category_id"))
    public List<Category> categories;
}
