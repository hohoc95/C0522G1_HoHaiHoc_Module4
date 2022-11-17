package com.example.service;

import com.example.model.OrderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IOrderProductService {
    void save(OrderProduct orderProduct);
    void update(OrderProduct orderProduct);

    Optional<OrderProduct> findById(Integer id);

    List<OrderProduct> findAll();

    Page<OrderProduct> findbyOrderProduct (Pageable pageable);
}
