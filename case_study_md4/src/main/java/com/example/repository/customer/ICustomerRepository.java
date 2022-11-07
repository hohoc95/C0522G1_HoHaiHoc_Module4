package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {


    Customer findById(int id);

    @Query(value = " select * from customer join customer_type " +
            " on customer.customer_type_id = customer_type.customer_type_id " +
            " where  " +
            " customer.customer_name like %:name%" +
            " and " +
            " customer.customer_email like %:email%" +
            " and " +
            " customer_type.customer_type_name like %:customerType%" +
            " and " +
            " customer.is_delete = 0 ",
            nativeQuery = true)
    Page<Customer> findByCustomerNameContaining(@Param("name") String name,
                                                @Param("email") String email,
                                                @Param("customerType") String customerType, Pageable pageable);

}
