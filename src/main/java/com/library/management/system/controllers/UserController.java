package com.library.management.system.controllers;

import com.library.management.system.dtos.request.UserRequest;
import com.library.management.system.dtos.response.UserResponse;
import com.library.management.system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/register")
    public UserResponse registerUser(UserRequest userRequest){

        return userService.registerUser(userRequest);
    }

    @PostMapping("/login")
    public UserResponse loginUser(UserRequest userRequest){
        return userService.loginUser(userRequest);
    }
}
