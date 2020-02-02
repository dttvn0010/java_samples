package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
    
    private @Autowired StudentService studentService;    
    
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Home page";
    }

    @GetMapping("/get_all_students")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(studentService.getAll());
    }
    
    @GetMapping("/get_student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") int id) {
        var stOpt = studentService.getById(id);
        return ResponseEntity.of(stOpt);
    }
    
    @PostMapping("/add_student")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        student = studentService.add(student);
        return ResponseEntity.ok(
                Map.of("success", true, "student", student)
            );
    }
    
    @PutMapping("/update_student/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        student = studentService.update(id, student);
        return ResponseEntity.ok(
                Map.of("success", true, "student", student)
            );
    }
    
    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        studentService.delete(id);
        return ResponseEntity.ok(Map.of("success", true));
    }
    
}
