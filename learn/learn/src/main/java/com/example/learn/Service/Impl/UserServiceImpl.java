package com.example.learn.Service.Impl;

import com.example.learn.Dto.UserRequest;
import com.example.learn.Entity.User;
import com.example.learn.Repo.UserRepo;
import com.example.learn.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User saveUser(UserRequest userRequest){
        User user=User.build(userRequest.getUserId(),
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getAge(),
                userRequest.getNationality());
        return userRepo.save(user);
    }
    @Override
    public List<User> getAllUser(){
        return userRepo.findAll();
    }
    @Override
    public User getUser(Long id){
        return userRepo.findByUserId(id);
    }
}
