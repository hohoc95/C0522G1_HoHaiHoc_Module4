package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    void save(Blog blog);
    void update(Blog blog);
    void remove(int id);
    Blog findById(int id);
    Page<Blog> findByNameContaining(String name , Pageable pageable);
}
