package com.example.repository;

import com.example.model.OrderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrderProductRepository extends JpaRepository<OrderProduct, Integer> {
    OrderProduct findById(int id);

    @Query(value = " select op.* from order_product op join product p on op.product_id = p.product_id join product_type pt on p.product_type_id = pt.product_type_id ",
        nativeQuery = true,
    countQuery = " select op.* from order_product op join product p on op.product_id = p.product_id join product_type pt on p.product_type_id = pt.product_type_id ")
//    @Query(value = "select * from order_product", nativeQuery = true)
    Page<OrderProduct> findbyOrderProduct(Pageable pageable);

}
