package com.create_blog.repository;

import com.create_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
