package com.example.shoppingapi.Cart;

import com.example.shoppingapi.model.Cart;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @Test
    void findCartByUserid() {
        List<Cart> carts = new ArrayList<>();
        Cart c1 = new Cart();
        c1.setCartid(1);
        c1.setUserid(1);
        c1.setItemid(1);
        c1.setItemqty(1);
        carts.add(c1);

        Cart c2 = new Cart();
        c2.setCartid(1);
        c2.setUserid(1);
        c2.setItemid(1);
        c2.setItemqty(1);
        carts.add(c2);

        when(cartRepository.findByUserid(1)).thenReturn(carts);
        //Act
        CartService cartService = new CartService();
        cartService.setCartRepository(cartRepository);
        ResponseEntity<List<Cart>> result = cartService.findCartByUserid(1);
        //Assert
        assertEquals(2,result.getBody().size());
    }

    @Test
    void addtoCart() {
        Cart c1 = new Cart();
        c1.setCartid(1);
        c1.setUserid(1);
        c1.setItemid(1);
        c1.setItemqty(1);
        when(cartRepository.save(c1)).thenReturn(c1);
        //Act
        CartService cartService = new CartService();
        cartService.setCartRepository(cartRepository);
        ResponseEntity<String>result = cartService.addtoCart(c1);
        //Assert
        assertEquals(HttpStatus.CREATED,result.getStatusCode());
    }
}