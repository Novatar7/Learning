package com.example.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAutoConfiguration
@SpringBootApplication
public class LearnApplication {
    // This is the start of your code
    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

}
