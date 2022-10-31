package com.create_blog.controller;

import com.create_blog.model.Category;
import com.create_blog.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category/v1")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    //Xem danh sách danh mục bài viết
    @GetMapping()
    public ResponseEntity<List<Category>> getCatogoryList() {
        List<Category> categoryList = categoryService.findAll();

        if (categoryList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    //Xem danh sách bài viết của 1 danh mục
    @GetMapping("/{id}")
    public ResponseEntity<Category> detailCategory(@PathVariable int id) {
        Category currentCategory = categoryService.findById(id);
        if (currentCategory == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(currentCategory, HttpStatus.OK);
    }
}
