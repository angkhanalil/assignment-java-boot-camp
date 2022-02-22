package com.example.shoppingapi.product;

import com.example.shoppingapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productServeice;

    //    findAll
    @GetMapping("/product")
    public List<Product> ProductAll() {
        return  productServeice.ShowProductAll() ;
    }

    //    findbyName -- Search by Name
    @GetMapping("/product/productname/{productname}")
    public ResponseEntity<List<ResponseProduct>> ProductName(@PathVariable String productname ) {
        return productServeice.ShowProductbyProductName_Contain(productname);

    }

    //    findById -- When Select one product
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getproductbyid(@PathVariable Integer id) {
        return  productServeice.ShowProductbyProductID(id);
    }

    //addnew product


}
