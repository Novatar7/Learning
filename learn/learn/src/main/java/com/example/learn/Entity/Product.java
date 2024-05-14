package com.example.learn.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Product_Name")
    private String productName;
    @Column(name = "Price")
    private Long price;
    @Column(name = "Created_By")
    private Long createdBy;
    @Column(name = "Date_Time")
    private LocalDateTime dateTime;

}
