package com.library.management.system.services;

import com.library.management.system.data.models.User;
import com.library.management.system.data.repositories.UserRepository;
import com.library.management.system.dtos.request.UserRequest;
import com.library.management.system.dtos.response.UserResponse;
import com.library.management.system.mappers.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.library.management.system.exceptions.EmailAlreadyExistsException;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

   private final UserRepository userRepository;

   private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


   @Autowired
    public UserServiceImpl(UserRepository userRepository){
      this.userRepository = userRepository;
    }

    @Override
    public UserResponse registerUser(UserRequest userRequest){
       User existingUser = userRepository.findByEmail(userRequest.getEmail()).orElse(null);
//       log.info("Existing user: {}",existingUser);
//        System.out.println("1111111");
//        System.out.println(existingUser);

       if(existingUser != null){
           throw new EmailAlreadyExistsException("Email already registered");
       }


       User user = UserMapper.toEntity(userRequest);

       user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

       User savedUser = userRepository.save(user);
       return UserMapper.toResponse(savedUser);
    }

    @Override
    public UserResponse loginUser(UserRequest userRequest){
        User user = userRepository.findByEmail(userRequest.getEmail()).orElseThrow(()->new RuntimeException("User not found"));


        if(!passwordEncoder.matches(userRequest.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return UserMapper.toResponse(user);
    }



}
