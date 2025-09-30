package com.library.management.system.services;

import com.library.management.system.data.models.User;
import com.library.management.system.data.repositories.UserRepository;
import com.library.management.system.dtos.request.UserRequest;
import com.library.management.system.dtos.response.UserResponse;
import com.library.management.system.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

   private final UserRepository userRepository;

   @Autowired
    public UserServiceImpl(UserRepository userRepository){
      this.userRepository = userRepository;
    }

    @Override
    public UserResponse registerUser(UserRequest userRequest){
       if(userRepository.existsByEmail(userRequest.getEmail())){
           throw new RuntimeException("Email already registered");
       }
       User user = UserMapper.toEntity(userRequest);
       userRepository.save(user);
       return UserMapper.toResponse(user);
    }

    @Override
    public UserResponse loginUser(UserRequest userRequest){
        User user = userRepository.findByEmail(userRequest.getEmail()).orElseThrow(()->new RuntimeException("User not found"));
        if(!user.getPassword().equals(userRequest.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return UserMapper.toResponse(user);
    }



}
