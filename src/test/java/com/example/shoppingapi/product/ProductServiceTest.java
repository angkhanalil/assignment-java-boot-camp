package com.example.shoppingapi.product;

import com.example.shoppingapi.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Test
    void showProductAll() {
        Product product1 = new Product();
        product1.setProductid(1);
        product1.setProductName("Adidas NMD1");
        product1.setPrice(3000.00);
        product1.setBrand("ADIDAS");
        product1.setProductDetails("detail");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProductid(2);
        product2.setProductName("NIKE AF1");
        product2.setPrice(3000.00);
        product2.setBrand("NIKE");
        product2.setProductDetails("detail");
        productRepository.save(product2);
        //Act

        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<Product> result = productService.ShowProductAll();
        //Assert
        assertNotNull(result);
    }

    @Test
    void showProductbyProductName_Contain() {

//        List<Product> product = new ArrayList<>();
//
//        Product product1 = new Product();
//        product1.setProductid(1);
//        product1.setProductName("Adidas NMD1");
//        product1.setPrice(3000.00);
//        product1.setBrand("ADIDAS");
//        product1.setProductDetails("detail");
//        product.add(product1);
////        productRepository.save(product1);
//
//        when(productRepository.findByProductNameContaining("Adidas")).thenReturn(  product );
////        //Act
//        ProductService productService = new ProductService();
//        productService.setProductRepository(productRepository);
//        ResponseEntity<List<ResponseProduct>> result = productService.ShowProductbyProductName_Contain("Adidas");
//        //Assert
//        assertEquals(new ResponseEntity<>(product, HttpStatus.OK) ,result);

    }

    @Test
    void showProductbyProductID() {

        Product product  = new Product();
        product.setProductid(1);
        product.setProductName("Adidas NMD1");
        product.setPrice(3000.00);
        product.setBrand("ADIDAS");
        product.setProductDetails("detail");

        when(productRepository.findByProductid(1)).thenReturn(  product );
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        ResponseEntity<Product> result = productService.ShowProductbyProductID(1);
        //Assert
        assertEquals(new ResponseEntity<>(product, HttpStatus.OK) ,result);
    }
}