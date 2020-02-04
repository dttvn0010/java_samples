package com.example.demo.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="book")
public class Book {

    @Id 
    public ObjectId id;
        
    public String code;
    
    public String name;
    
    public Author author;
    
    public List<Category> categories;
}
