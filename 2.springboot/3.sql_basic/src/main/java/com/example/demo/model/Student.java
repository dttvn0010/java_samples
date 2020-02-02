package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

    @Id 
    @GeneratedValue
    public int id;
    
    @Column
    public String studentNo;
    
    @Column
    public String name;
    
}
