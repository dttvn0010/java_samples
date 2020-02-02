package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

    @Id @GeneratedValue 
    public int id;
    
    @Column
    public String code;
    
    @Column
    public String name;
    
    @JsonIgnore
    @ManyToMany(fetch=FetchType.LAZY, mappedBy = "categories")
    public List<Book> books;
    
}
