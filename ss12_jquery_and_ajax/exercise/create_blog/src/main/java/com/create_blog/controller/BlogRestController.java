package com.create_blog.controller;

import com.create_blog.model.Blog;
import com.create_blog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog/v1")
public class BlogRestController {
    @Autowired
    private BlogService blogService;

    //Xem danh sách các bài viết
    @GetMapping
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = blogService.findAll();

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    //Xem chi tiết bài viết
    @GetMapping("/{id}")
    public ResponseEntity<Blog> detailBlog(@PathVariable int id) {
        Blog currentBlog = blogService.findById(id);
        if (currentBlog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(currentBlog, HttpStatus.OK);
    }

}
