package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

@Service
public class StudentService {

    @SuppressWarnings("serial")
    List<Student> students = new ArrayList<>() {{
        add(new Student(1, "10001", "Nguyen Van A"));
        add(new Student(2, "10002", "Nguyen Van B"));
    }};
            
    
    public List<Student> getAll() {
        return students;
    }
    
    public Optional<Student> getById(int id) {
        return students.stream().filter(x -> x.id == id).findFirst();
    }
    
    public Student add(Student st) {
        var maxId = students.size() > 0? students.get(students.size() - 1).id : 0;
        st.id = maxId + 1;
        students.add(st);
        return st;
    }
    
    public Student update(int id, Student st) {
        st.id = id;
        for(int i = 0; i < students.size(); i++) {
            if(st.id == students.get(i).id) {
                students.set(i, st);
            }
        }
        return st;
    }
    
    public void delete(int id) {
        var stOpt = getById(id);
        stOpt.ifPresent(st -> students.remove(st));
    }
    
}
