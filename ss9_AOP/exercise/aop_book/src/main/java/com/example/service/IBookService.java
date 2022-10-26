package com.example.service;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Page<Book> findALl(Pageable pageable);
    void save(Book book);
    void update(Book book);
    void remove(int id);
    Book findById(int id);
    Page<Book> findByBookTitleContaining(String name , Pageable pageable);
}
