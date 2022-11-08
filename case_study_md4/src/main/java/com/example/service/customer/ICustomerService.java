package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
//    List<Customer> findAll();
    Customer findById(int id);
//    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findByCustomerNameContaining(String name,String email,String customerType, Pageable pageable);

    void save(Customer customer);
    void update(Customer customer);
    void remove(int id);
//    void delete(int id);

}
