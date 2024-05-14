package com.example.learn.Dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class RequestProduct {

    private Long id;
    @NotNull(message = "Product Name should not be null")
    private String productName;
    @NotNull(message = "Created by is null")
    private String createdBy;
    private LocalDateTime dateTime;
}
