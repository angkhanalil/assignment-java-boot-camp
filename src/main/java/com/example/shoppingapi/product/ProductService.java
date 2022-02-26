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


    public List<Product> ShowProductAll() {
        List<Product> result = productRepository.findAll();
        return result;
    }


    public ResponseEntity<List<ResponseProduct>> ShowProductbyProductName_Contain(String productname) {
        List<Product> result = productRepository.findByProductNameContainingIgnoreCase(productname);
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
        if(result != null){
            return new ResponseEntity<>(result, HttpStatus.OK) ;
        }
        throw new ProductNotFoundException("Product");
    }
}
