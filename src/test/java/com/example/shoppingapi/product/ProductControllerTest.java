package com.example.shoppingapi.product;

import com.example.shoppingapi.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ProductRepository productRepository;


    @Test
    void productAll() {
        //Arrange
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductid(1);
        product1.setProductName("Adidas NMD1");
        product1.setPrice(3000.00);
        product1.setBrand("ADIDAS");
        product1.setProductDetails("detail");
        products.add(product1);

        when(productRepository.findAll()).thenReturn(products);
//        //Act
        List<Product>  result = productRepository.findAll();
                //(List<Product>) testRestTemplate.getForObject("/product", Product.class);
//        //Assert
        assertEquals(1,result.size());
    }

    @Test
    @DisplayName("Search Product Name")
    void productName() {
        //Arrange

        //Act
        //Assert


    }

    @Test
    @DisplayName("get product detail")
    void getproductbyid() {
        //Arrange

    }
}