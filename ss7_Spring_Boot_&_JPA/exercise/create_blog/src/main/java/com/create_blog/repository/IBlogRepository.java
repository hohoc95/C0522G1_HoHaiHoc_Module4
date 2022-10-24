package com.create_blog.repository;

import com.create_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Blog findById(int id);
//    List<Blog> findByNameContaining(String keyword);


}
