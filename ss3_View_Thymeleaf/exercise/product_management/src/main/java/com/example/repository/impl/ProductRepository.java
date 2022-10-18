package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> productList;

    static{
        productList = new HashMap<>();
        productList.put(1, new Product(1,"A",500,"AA"));
        productList.put(2, new Product(2,"B",500,"BB"));
        productList.put(3, new Product(3,"C",500,"CC"));
        productList.put(4, new Product(4,"D",500,"DD"));
        productList.put(5, new Product(5,"E",500,"EE"));
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void findByName(String name) {

    }
}
