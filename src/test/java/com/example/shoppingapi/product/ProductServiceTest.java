package com.example.shoppingapi.product;

import com.example.shoppingapi.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setup() {

    }

    @Test
    void showProductAll() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductid(1);
        product1.setProductName("Adidas NMD1");
        product1.setPrice(3000.00);
        product1.setBrand("ADIDAS");
        product1.setProductDetails("detail");
        products.add(product1);
//        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProductid(2);
        product2.setProductName("NIKE AF1");
        product2.setPrice(3000.00);
        product2.setBrand("NIKE");
        product2.setProductDetails("detail");
        products.add(product2);
//        productRepository.save(product2);

        when(productRepository.findAll()).thenReturn(products);
        //Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<Product> result = productService.ShowProductAll();
        //Assert
        assertNotNull(result);
        assertEquals(2,result.size());

    }

    @Test
    void showProductbyProductName_Contain() {

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductid(1);
        product1.setProductName("Adidas NMD1");
        product1.setPrice(3000.00);
        product1.setBrand("ADIDAS");
        product1.setProductDetails("detail");
        products.add(product1);
//        productRepository.save(product1);


        when(productRepository.findByProductNameContaining("Adidas")).thenReturn(  products );
////        //Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        ResponseEntity<List<ResponseProduct>> result = productService.ShowProductbyProductName_Contain("Adidas");
        //Assert
        assertEquals(1,result.getBody().size());
//        assertEquals(new ResponseEntity<>(product, HttpStatus.OK) ,result);

    }

    @Test
    void showProductbyProductID() {

        Product product = new Product();
        product.setProductid(1);
        product.setProductName("Adidas NMD1");
        product.setPrice(3000.00);
        product.setBrand("ADIDAS");
        product.setProductDetails("detail");

        when(productRepository.findByProductid(2)).thenReturn(product);
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        ResponseEntity<Product> result = productService.ShowProductbyProductID(1);
        //Assert
        assertEquals(new ResponseEntity<>(product, HttpStatus.OK), result);
    }
}