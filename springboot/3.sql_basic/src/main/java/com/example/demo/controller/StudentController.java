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
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/get_students")
    public ResponseEntity<?> getStudents(@RequestParam("start") int start, @RequestParam("count") int count) {
        return ResponseEntity.ok(studentService.getList(start, count));
    }
    
    @GetMapping("/get_student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") int id) {
        var stOpt = studentService.getById(id);
        return ResponseEntity.of(stOpt);
    }
    
    @GetMapping("/get_student_by_number/{number}")
    public ResponseEntity<?> getStudentByNumber(@PathVariable("number") String studentNo) {
        var stOpt = studentService.getByStudentNo(studentNo);
        return ResponseEntity.of(stOpt);
    }
    
    @GetMapping("/search_student")
    public ResponseEntity<?> searchStudent(@RequestParam("keyword") String keyword, 
                                            @RequestParam("start") int start, 
                                            @RequestParam("count") int count) {
        var lst = studentService.search(keyword, start, count);
        return ResponseEntity.ok(lst);
    }
    
    @GetMapping("/count_student")
    public long countStudent(@RequestParam("keyword") String keyword) {
        return studentService.countSearch(keyword);
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
