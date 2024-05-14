package com.example.learn.Controller;

import com.example.learn.Dto.RequestProduct;
import com.example.learn.Entity.Product;
import com.example.learn.Service.LearnService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LearnController {

    @Autowired
    LearnService learnService;

    //    @GetMapping
//    public String helloworld(){
//       return ("Hello world");
//    }
    @PostMapping
    public ResponseEntity<Object> createEntry(@RequestBody RequestProduct requestProduct) {
        return learnService.createProduct(requestProduct);
    }

    @GetMapping("id/{myid}")
    public Product getById(@PathVariable Long myid) {
        return learnService.getProductById(myid).orElse(null);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(learnService.findAllProduct());
    }

    @PutMapping("id/{id}")
    public Product updateAzabkoEntryById(@PathVariable Long id, @RequestBody Product updateEntry) {
        Product old = (Product) learnService.getProductById(id).orElse(null);
        if (old != null) {
            old.setProductName(updateEntry.getProductName() != null && !updateEntry.getProductName().equals("") ? updateEntry.getProductName() : old.getProductName());
        }
        learnService.saveProduct(old);
        return old;

    }

    @GetMapping("product/{myPro}")
    public List<Product> getByProduct(@PathVariable String myPro) {
        return learnService.getProduct(myPro);
    }

}
