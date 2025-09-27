/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.studentapp.service.impl;
import com.example.studentapp.entity.Student;
import com.example.studentapp.repository.StudentRepository;
import com.example.studentapp.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
/**
 *
 * @author hp
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    
private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Student> findAll() {
        return repo.findAll();
    }

    @Override
    public Student findById(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new NoSuchElementException("Student id " + id + " not found"));
    }

    @Override
    public Student create(Student s) {
        s.setId(null);               // ensure new row
        return repo.save(s);
    }

    @Override
    public Student update(Long id, Student s) {
        Student current = findById(id); // throws if not found
        current.setName(s.getName());
        current.setMajor(s.getMajor());
        current.setGrade(s.getGrade());
        return repo.save(current);
    }

    @Override
    public void delete(Long id) {
        Student current = findById(id); // throws if not found
        repo.delete(current);
    }
}
