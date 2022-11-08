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

    @Query(value = "select c.* from customer c join customer_type ct on c.customer_type_id = ct.customer_type_id where c.customer_name like %:name% and c.customer_email like %:email% and ct.customer_type_name like %:customerType% and c.is_delete = 0",
            nativeQuery = true,
    countQuery = "select count(*) from (select c.* from customer c join customer_type ct on c.customer_type_id = ct.customer_type_id where c.customer_name like %:name% and c.customer_email like %:email% and ct.customer_type_name like %:customerType% and c.is_delete = 0) abc")
    Page<Customer> findByCustomer(@Param("name") String name,
                                  @Param("email") String email,
                                  @Param("customerType") String customerType, Pageable pageable);


//    @Query(value = "select c.* from customer c join customer_type ct on c.customer_type_id = ct.customer_type_id where c.customer_name like %:name% and c.customer_email like %:email2% and ct.customer_type_name like %:customerType% and c.is_delete = 0",
//            nativeQuery = true,
//            countQuery = "select count(*) from (select c.* from customer c join customer_type ct on c.customer_type_id = ct.customer_type_id where c.customer_name like %:name% and c.customer_email like %:email2% and ct.customer_type_name like %:customerType% and c.is_delete = 0) abc")
//    Page<Customer> findByCustomer(@Param("name") String name,
//                                  @Param("email2") String email,
//                                  @Param("customerType") String customerType, Pageable pageable);


// Câu truy vấn trong My SQL
//    select * from customer
//    join customer_type on customer.customer_type_id = customer_type.customer_type_id
//    where customer.customer_name like '%%'
//    and customer.customer_email like '%%'
//    and customer_type.customer_type_name like '%%'
//    and customer.is_delete = 0 ;
//
// Hoặc
//
//select * from customer join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer.customer_name like '%%' and customer.customer_email like '%%' and customer_type.customer_type_name like '%%' and customer.is_delete = 0 ;

}

