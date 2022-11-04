package com.example.service.customer.impl;

import com.example.model.customer.Customer;
import com.example.repository.customer.ICustomerRepository;
import com.example.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

//    @Override
//    public List<Customer> findAll() {
//        return iCustomerRepository.findAll();
//    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

//
//    @Override
//    public Page<Customer> findAll(Pageable pageable) {
//        return iCustomerRepository.findAll(pageable);
//    }

    @Override
    public Page<Customer> findByCustomerNameContaining(String name, Pageable pageable) {
        return iCustomerRepository.findByCustomerNameContaining(name, pageable);
    }

//    @Override
//    public Page<Customer> searchCustomer(String nameSearch, String customerTypeSearch, String phoneSearch, Pageable pageable) {
//        return iCustomerRepository.searchCustomer(nameSearch, customerTypeSearch, phoneSearch, pageable);
//    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.deleteById(id);
    }

//    @Override
//    public void delete(int id) {
//        iCustomerRepository.delete(id);
//    }
}
