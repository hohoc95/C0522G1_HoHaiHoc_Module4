package com.create_blog.service;

import com.create_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    void save(Blog blog);
//    void delete(int id);
//    List<Blog> findByName(String keyword);
}
