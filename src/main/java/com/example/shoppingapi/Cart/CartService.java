package com.example.shoppingapi.Cart;

import com.example.shoppingapi.model.Cart;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public ResponseEntity<List<Cart>> findCartByUserid(Integer userid) {
        List<Cart> carts = cartRepository.findByUserid(userid);
        if (!carts.isEmpty()) {
            return new ResponseEntity<>(carts,HttpStatus.OK);
        }
//        return  new ResponseEntity<>(carts, HttpStatus.NOT_FOUND);
        throw new CartNotFoundException(userid.toString());
    }

    //    add
    @Transactional
    public ResponseEntity<Cart> addtoCart(@NotNull Cart newcart) {
         if(newcart.getItemqty() <= 0){
             throw new InvalidfieldsException("Item QTY");
         }else{
             Cart cart = cartRepository.save(newcart);
             if (cart == null) {
                 return new ResponseEntity<>(cart, HttpStatus.NOT_FOUND);
             }
             return new ResponseEntity<>(cart, HttpStatus.CREATED);
         }


    }

}
