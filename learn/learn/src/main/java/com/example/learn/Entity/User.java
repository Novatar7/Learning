package com.example.learn.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_tbl")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Userid")
    private Long userId;
    @Column(name="Name")
    private String name;
    @Column(name="Email")
    private String email;
    @Column(name="Mobile")
    private String mobile;
    @Column(name="Gender")
    private String gender;
    @Column(name="Age")
    private int age;
    @Column(name="Nationality")
    private String nationality;

}
