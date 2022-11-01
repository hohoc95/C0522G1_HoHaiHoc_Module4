package com.create_blog.service.impl;

import com.create_blog.model.Category;
import com.create_blog.repository.IBlogRepository;
import com.create_blog.repository.ICategoryRepository;
import com.create_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public void update(Category category) {
        iCategoryRepository.save(category);
    }

//    @Override
//    public void remove(int id) {
//        iCategoryRepository.delete(findById(id));
//    }
}
