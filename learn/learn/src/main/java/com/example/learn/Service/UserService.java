package com.example.learn.Service;

import com.example.learn.Dto.UserRequest;
import com.example.learn.Entity.User;

import java.util.List;

public interface UserService {

    public User saveUser(UserRequest userRequest);
    public List<User> getAllUser();
    public User getUser(Long id);
}
