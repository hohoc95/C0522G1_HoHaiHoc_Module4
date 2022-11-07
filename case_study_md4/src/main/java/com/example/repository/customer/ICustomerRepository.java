package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAll();

    Customer findById(int id);

//    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findByCustomerNameContaining(String name , Pageable pageable);


//    @Query(value = "select  * " +
//            "from  customer" +
//            " where customer_name like %:nameSearch% and customer_email like %:emailSearch% and is_delete = false ",
//            nativeQuery = true)
//    @Query(value = "select  * " +
//            "from  customer" +
//            " where customer_name like %:name% and customer_email like %:email% and is_delete = false ",
//            nativeQuery = true)


//    Page<Customer>  searchCustomer (@Param("nameSearch") String nameSearch,
//                                    @Param("emailSearch") String emailSearch,Pageable pageable);

//    Page<Customer>  searchCustomer (@Param("name") String name,
//                                    @Param("email") String email,Pageable pageable);


//    @Query(value = "update customer set is_delete = 1 where id = :idKeyword ;" , nativeQuery = true)
//    void delete(@Param("idKeyword") int id);

}
