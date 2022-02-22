package com.example.shoppingapi.product;

import com.example.shoppingapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {


    List<Product> findAll();

//    @Query("select p from Product p where p.productid = ?1")
    Product findByProductid(Integer id);

//    @Query("select p from Product p where p.productName like concat('%', ?1, '%')")
    List<Product> findByProductNameContaining(String ProductName);

//    Optional<Product> findByProductName_Containing(String productName);


}
