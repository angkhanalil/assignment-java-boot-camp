package com.example.shoppingapi.Cart;

import com.example.shoppingapi.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {

//    @Query("select c from Cart c where c.userid = ?1")
    List<Cart> findByUserid(Integer userid);
}
