package com.example.learn.Service.Impl;

import com.example.learn.Dto.CustomResponse;
import com.example.learn.Dto.RequestProduct;
import com.example.learn.Entity.Product;
import com.example.learn.Repo.LearnRepo;
import com.example.learn.Service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class LearnServiceImpl implements LearnService {
    @Autowired
    private LearnRepo learnRepo;

    @Override
    public Product saveProduct(Product product) {
        return learnRepo.save(product);
    }

    @Override
    public Product saveAllProduct(List<Product> product) {
        return (Product) learnRepo.saveAll(product);
    }

    @Override
    public List<Product> getProduct(String productName) {
        return learnRepo.findByProduct(productName);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        try {
            if (id == null) {
                throw new Exception("Id null cha");
            } else {
                return learnRepo.findById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Product> findAllProduct() {
        return learnRepo.findAll();
    }

    @Override
    public ResponseEntity<Object> createProduct(RequestProduct requestProduct) {

        try {
            if (requestProduct.getProductName() == null) {
//                throw new CustomResponse("Please enter value");
                throw new CustomResponse(String.valueOf(CustomResponse.empty()));
            }
            //dto to entity and vice versa mapper
            Product product = new Product();
            product.setId(requestProduct.getId());
            product.setProductName(requestProduct.getProductName());
            product.setCreatedBy(1L);
            product.setDateTime(LocalDateTime.now());
            learnRepo.save(product);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } catch (CustomResponse e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//            throw new CustomResponse(e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//            throw new CustomResponse(e.getMessage());
//            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
