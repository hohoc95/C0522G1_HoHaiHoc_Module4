package com.create_blog.service;

import com.create_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
