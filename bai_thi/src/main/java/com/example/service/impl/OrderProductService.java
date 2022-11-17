package com.example.service.impl;

import com.example.model.OrderProduct;
import com.example.repository.IOrderProductRepository;
import com.example.service.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderProductService implements IOrderProductService {
    @Autowired
    private IOrderProductRepository iOrderProductRepository;

    @Override
    public void save(OrderProduct orderProduct) {
        iOrderProductRepository.save(orderProduct);
    }

    @Override
    public void update(OrderProduct orderProduct) {
        iOrderProductRepository.save(orderProduct);
    }

    public Optional<OrderProduct> findById(Integer id) {
        return iOrderProductRepository.findById(id);
    }

    @Override
    public List<OrderProduct> findAll() {
        return iOrderProductRepository.findAll();
    }

    @Override
    public Page<OrderProduct> findbyOrderProduct(Pageable pageable) {
        return iOrderProductRepository.findbyOrderProduct(pageable);
    }
}
