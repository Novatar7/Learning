package com.example.learn.Repo;

import com.example.learn.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
// communicates with database
public interface LearnRepo extends JpaRepository<Product, Long> {

    Entity findById(long id);

    @Query(value = "Select * from Product p where p.productName=:productName", nativeQuery = true)
    List<Product> findByProduct(String productName);

}
