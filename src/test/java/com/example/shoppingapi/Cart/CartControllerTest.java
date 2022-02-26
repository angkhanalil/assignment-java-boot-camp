package com.example.shoppingapi.Cart;

import com.example.shoppingapi.model.Cart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CartControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private CartRepository cartRepository;

    @Test
    void addtocart() {
    }

    @Test
    @DisplayName("show basket")
    void cart() {
//Arrange
        List<Cart> cartList = new ArrayList<>();
        Cart cart = new Cart();
        cart.setCartid(1);
        cart.setItemid(1);
        cart.setItemqty(1);
        cart.setUserid(1);
        cartList.add(cart);
        when(cartRepository.findByUserid(1)).thenReturn(cartList);

        //Act
        String result = testRestTemplate.getForObject("/cart/1", String.class);
        //assert
        assertNotNull(result.isEmpty());
    }
}