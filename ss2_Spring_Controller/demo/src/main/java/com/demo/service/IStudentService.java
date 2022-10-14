package com.demo.service;

import com.demo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    public List<Student> findByName(String keyword);
}
