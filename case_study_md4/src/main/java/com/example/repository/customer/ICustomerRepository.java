package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAll();
//    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findByCustomerNameContaining(String name , Pageable pageable);

    Customer findById(int id);

//    @Query(value = "update customer set is_delete = 1 where id = :idKeyword ;" , nativeQuery = true)
//    void delete(@Param("idKeyword") int id);

}
