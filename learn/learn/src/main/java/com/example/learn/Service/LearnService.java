package com.example.learn.Service;


import com.example.learn.Dto.RequestProduct;
import com.example.learn.Entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface LearnService {

    public ResponseEntity<Object> createProduct(RequestProduct product);

    public Product saveProduct(Product product);

    public Product saveAllProduct(List<Product> product);

    public Optional<Product> getProductById(Long id);

    public List<Product> getProduct(String productName);

    public List<Product> findAllProduct();

}
