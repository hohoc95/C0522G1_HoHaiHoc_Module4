package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void update(Product product);
    void delete(int id);
    void findByName(String name);
}
