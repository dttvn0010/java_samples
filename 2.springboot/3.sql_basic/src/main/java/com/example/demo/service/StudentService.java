package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired private StudentRepository studentRepository;
    
    @PersistenceContext private EntityManager em;
                
    public List<Student> getAll() {
        var students = new ArrayList<Student>();
        studentRepository.findAll().forEach(x -> students.add(x));
        return students;
    }
    
    
    public List<Student> getList(int start, int count) {
        var pageable = new OffsetBasedPageable(count, start, Sort.by("id"));
        var students = studentRepository.findAll(pageable);
        return students.stream().collect(Collectors.toList());
    }
    
    public Optional<Student> getById(int id) {
        return studentRepository.findById(id);
    }
    
    public Student add(Student st) {
        return studentRepository.save(st);
    }
    
    public Student update(int id, Student st) {
        st.id = id;
        return studentRepository.save(st);
    }
    
    public void delete(int id) {
        studentRepository.deleteById(id);
    }
    
    public Optional<Student> getByStudentNo(String studentNo) {
        return studentRepository.findByStudentNo(studentNo);
    }    
    
    public List<Student> search(String keyword, int start, int count) {
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(Student.class);
        var root = cq.from(Student.class);
        
        cq.select(root)
          .where(
             cb.or(
                 cb.like(root.get("studentNo"), "%" + keyword + "%"),
                 cb.like(root.get("name"), "%" + keyword + "%")
             )             
          );
        
        
        var query = em.createQuery(cq);
        query.setFirstResult(start);
        query.setMaxResults(count);
        
        return query.getResultList();
    }
    
    public List<Student> search2(String keyword, int start, int count) {
        var queryStr = "SELECT s FROM Student s WHERE name LIKE ?1 OR studentNo LIKE ?2";
        var query = em.createQuery(queryStr, Student.class);
        query.setParameter(1, "%" + keyword + "%");
        query.setParameter(2, "%" + keyword + "%");
        query.setFirstResult(start);
        query.setMaxResults(count);
        return query.getResultList();
    }
    
    public long countSearch(String keyword) {
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(Long.class);
        var root = cq.from(Student.class);
        
        cq.multiselect(cb.count(root))
          .where(cb.or(
                cb.like(root.get("studentNo"), "%" + keyword + "%"),
                cb.like(root.get("name"), "%" + keyword + "%")
            )
        );
        
        return em.createQuery(cq).getSingleResult();
    }
    
    public long countSearch2(String keyword) {
        var queryStr = "SELECT COUNT(s) FROM Student s WHERE name LIKE ?1 OR studentNo LIKE ?2";
        var query = em.createQuery(queryStr, Long.class);
        query.setParameter(1, "%" + keyword + "%");
        query.setParameter(2, "%" + keyword + "%");
        return query.getSingleResult();
    }
}
