package com.example.shoppingapi.product;

import com.example.shoppingapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    void initialize() {
        Product product1 = new Product();
        product1.setProductid(1);
        product1.setProductName("Adidas NMD1");
        product1.setPrice(3000.00);
        product1.setBrand("ADIDAS");
        product1.setProductDetails("detail");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProductid(2);
        product2.setProductName("Adidas NMD2");
        product2.setPrice(3000.00);
        product2.setBrand("ADIDAS");
        product2.setProductDetails("detail");
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setProductid(3);
        product3.setProductName("NIKE AF1");
        product3.setPrice(3000.00);
        product3.setBrand("NIKE");
        product3.setProductDetails("detail NIKE");
        productRepository.save(product3);
    }

    public List<Product> ShowProductAll() {
        List<Product> result = productRepository.findAll();
        return result;
    }


    public ResponseEntity<List<ResponseProduct>> ShowProductbyProductName_Contain(String productname) {
        List<Product> result = productRepository.findByProductNameContaining(productname);
        List<ResponseProduct> responseproducts = new ArrayList<>();
        if(!result.isEmpty()){
            for(Product prods : result){
                ResponseProduct res = new ResponseProduct();
                res.setProductid(prods.getProductid());
                res.setProductname(prods.getProductName());
                res.setSellprice(prods.getPrice());
                res.setPrice(prods.getPrice());
                responseproducts.add(res);
            }
            return new ResponseEntity<>(responseproducts, HttpStatus.OK) ;
        }
        throw new ProductNotFoundException(productname);
        //ErrorResponseProduct

    }

    public ResponseEntity<Product> ShowProductbyProductID(Integer id) {
        Product result = productRepository.findByProductid(id);
        if(!result.equals(null)){
            return new ResponseEntity<>(result, HttpStatus.OK) ;
        }
        throw new ProductNotFoundException("Product");
    }
}
