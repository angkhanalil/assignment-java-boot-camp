package com.example.shoppingapi.Cart;

import com.example.shoppingapi.model.Cart;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

//    add to cart
    @PostMapping("/cart")
    public ResponseEntity<Cart> addtocart(@RequestBody @NotNull Cart carts){
       return cartService.addtoCart(carts);

    }

    @GetMapping("/cart/{userid}")
    public ResponseEntity<List<CartResponse>> Cart(@PathVariable Integer userid){
        return cartService.findCartWithProductByUserid(userid);
    }
}
