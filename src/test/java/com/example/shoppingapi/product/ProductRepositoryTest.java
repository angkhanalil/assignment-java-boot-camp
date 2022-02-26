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
        Product result = productRepository.findByProductid(6);
        //Assert
        assertNull(result);

    }

    @Test
    void findByProductNameContaining_With_success() {
        Product product1 = new Product();
        product1.setProductid(1);
        product1.setProductName("adidas ORIGINALS Stan Smith Shoes Women White");
        product1.setPrice(1792.00);
        product1.setBrand("adidas");
        product1.setProductDetails("Despite their history on the tennis courts, you don't need a racket and short shorts to appreciate the clean-cut style of the adidas Stan Smith trainer.");
        product1.setCategory("shoes");
        product1.setSku("");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProductid(2);
        product2.setProductName("adidas ORIGINALS NMD_R1");
        product2.setPrice(2576.00);
        product2.setBrand("adidas");
        product2.setProductDetails("Continue the NMD legacy in these adidas NMD_R1 Shoes");
        product2.setCategory("shoes");
        product2.setSku("2282329674_TH-7670241944");
        productRepository.save(product2);
        //Act
        List<Product> result = productRepository.findByProductNameContainingIgnoreCase("Adidas");
        //Assert
        assertNotNull(result);
        assertEquals(2,result.size());

    }

    @Test
    void findByProductNameContaining_With_failed() {
        Product product  = new Product();
        product.setProductid(1);
        product.setProductName("Adidas NMD1");
        product.setPrice(3000.00);
        product.setBrand("ADIDAS");
        product.setProductDetails("detail");
        productRepository.save(product);

        //Act
        List<Product> result = productRepository.findByProductNameContainingIgnoreCase("Nivea");
        System.out.println("result.size() " + result.size());
        //Assert
        assertEquals(0,result.size());
    }


}