package com.example.shoppingapi.product;

import com.example.shoppingapi.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private  ProductRepository productRepository;
    @Test
    void findAll() {

        Product product  = new Product();
        product.setProductid(1);
        product.setProductName("Adidas NMD1");
        product.setPrice(3000.00);
        product.setBrand("ADIDAS");
        product.setProductDetails("detail");
        productRepository.save(product);
        //Act
        List<Product> result = productRepository.findAll();
        //Assert
        assertTrue(!result.isEmpty());
    }

    @Test
    void findByProductid_With_Success() {
        Product product  = new Product();
        product.setProductid(1);
        product.setProductName("Adidas NMD1");
        product.setPrice(3000.00);
        product.setBrand("ADIDAS");
        product.setProductDetails("detail");
        productRepository.save(product);
        //Act
        Product result = productRepository.findByProductid(1);
        //Assert
        assertNotNull(result);

    }

    @Test
    void findByProductid_With_NotFound() {
        Product product  = new Product();
        product.setProductid(1);
        product.setProductName("Adidas NMD1");
        product.setPrice(3000.00);
        product.setBrand("ADIDAS");
        product.setProductDetails("detail");
        productRepository.save(product);
        //Act
        Product result = productRepository.findByProductid(2);
        //Assert
        assertNull(result);

    }

    @Test
    void findByProductNameContaining_With_success() {
        Product product  = new Product();
        product.setProductid(1);
        product.setProductName("Adidas NMD1");
        product.setPrice(3000.00);
        product.setBrand("ADIDAS");
        product.setProductDetails("detail");
        productRepository.save(product);
        //Act
        List<Product> result = productRepository.findByProductNameContaining("Adidas");
        //Assert
        assertNotNull(result);

    }


}