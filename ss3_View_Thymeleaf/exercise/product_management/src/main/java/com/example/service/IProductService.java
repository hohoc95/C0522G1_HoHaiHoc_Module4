package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void update(Product product);
    void remove(int id);
    Product findById(int id);
    List<Product> findByName(String name);
}
