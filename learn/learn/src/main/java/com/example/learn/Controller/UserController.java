package com.example.learn.Controller;

import com.example.learn.Dto.CustomResponse;
import com.example.learn.Dto.UserRequest;
import com.example.learn.Entity.InputFieldError;
import com.example.learn.Entity.User;
import com.example.learn.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public User saveUser(@RequestBody @Valid UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    @GetMapping("/fetchall")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(Long myid) {
        return ResponseEntity.ok(userService.getUser(myid));
    }

//    @PutMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CustomResponse> updateUser(
//            @RequestBody @Valid User user,
//            BindingResult bindingResult) {
//
//        if (bindingResult.hasFieldErrors()) {
//
//            List<InputFieldError> fieldErrorList = bindingResult.getFieldErrors().stream()
//                    .map(error -> new InputFieldError(error.getField(), error.getDefaultMessage()))
//                    .toList();
//
//            CustomResponse updateResponse = new CustomResponse(fieldErrorList.toString());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(updateResponse);
//        } else {
//            // Update logic...
//            return ResponseEntity.status(HttpStatus.OK).build();
//        }
//    }
}
