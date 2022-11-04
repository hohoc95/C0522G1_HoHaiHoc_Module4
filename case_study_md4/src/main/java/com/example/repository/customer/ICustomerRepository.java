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

//    @Query(value = "select * from customer where customer_name like %:nameSearch% and " +
//            "customer_type_name like %:customerTypeName% and customer_phone like %:phoneSearch%",
//            nativeQuery = true)
//    Page<Customer> searchCustomer(@Param("nameSearch") String nameSearch, @Param("customerTypeSearch") String customerTypeSearch,
//                                  @Param("phoneSearch") String phoneSearch, Pageable pageable);

//    @Query(value = "select * from customer where customer_name like %:name% and customer_phone like %:customerPhone% and customer_type_name like %:customerTypeName%",nativeQuery = true)
//    Page<Customer> searchName(@Param("name") String name, @Param("customerPhone") String customerPhone, @Param("customerTypeName") String customerTypeName, Pageable pageable);


//    @Query(value = "select * from customer  where ((customer_name like name) and (customer_email like email) and( customer_type)) ")

//    @Query(value = "update customer set is_delete = 1 where id = :idKeyword ;" , nativeQuery = true)
//    void delete(@Param("idKeyword") int id);

}
