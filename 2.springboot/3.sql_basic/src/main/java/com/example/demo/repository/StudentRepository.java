package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByStudentNo(String studentNo);
    
    @Query(value="SELECT s FROM Student s WHERE s.studentNo = ?1")
    List<Student> findByStudentNo2(String studentNo);
    
    Page<Student> findAll(Pageable pageable);
}
