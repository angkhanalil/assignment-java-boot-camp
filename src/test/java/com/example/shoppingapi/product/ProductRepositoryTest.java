package com.example.shoppingapi.product;

import com.example.shoppingapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private  ProductRepository productRepository;

    @BeforeEach
    void setup(){
        Product product  = new Product();
        product.setProductid(1);
        product.setProductName("Adidas NMD1");
        product.setPrice(3000.00);
        product.setBrand("ADIDAS");
        product.setProductDetails("detail");
        productRepository.save(product);
    }

    @Test
    void findAll() {

        //Act
        List<Product> result = productRepository.findAll();
        //Assert
        assertTrue(!result.isEmpty());
    }

    @Test
    void findByProductid_With_Success() {
        //Act
        Product result = productRepository.findByProductid(1);
        //Assert
        assertNotNull(result);

    }

    @Test
    void findByProductid_With_NotFound() {
        //Act
        Product result = productRepository.findByProductid(2);
        //Assert
        assertNull(result);

    }

    @Test
    void findByProductNameContaining_With_success() {
        //Act
        List<Product> result = productRepository.findByProductNameContaining("Adidas");
        //Assert
        assertNotNull(result);
        assertEquals(1,result.size());

    }

    @Test
    void findByProductNameContaining_With_failed() {
        //Act
        List<Product> result = productRepository.findByProductNameContaining("Nike");
        System.out.println("result.size() " + result.size());
        //Assert
        assertEquals(0,result.size());
    }


}