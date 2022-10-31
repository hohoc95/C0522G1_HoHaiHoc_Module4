package com.create_blog.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BlogDto implements Validator {
    private int id;
    private String title;
    private String author;
    private String date;

    private String content;



    public BlogDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BlogDto blogDto = (BlogDto) target;
//        if ("title".equals(BlogDto.getTitle())){
//            errors.rejectValue("title","title.forbidden","Không được trống title");
//        }
    }
}
