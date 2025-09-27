/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.studentapp.service;

import com.example.studentapp.entity.Student;
import java.util.List;
/**
 *
 * @author hp
 */
public interface StudentService {
    
   List<Student> findAll();
    Student findById(Long id);
    Student create(Student s);
    Student update(Long id, Student s);
    void delete(Long id);
}
