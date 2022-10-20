package com.create_blog.service.impl;

import com.create_blog.model.Blog;
import com.create_blog.repository.IBlogRepository;
import com.create_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

//    @Override
//    public void save(Blog blog) {
//        iBlogRepository.save(blog);
//    }
//
//    @Override
//    public void delete(int id) {
//        iBlogRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Blog> findByName(String keyword) {
//        return iBlogRepository.findByName(keyword);
//    }
}
