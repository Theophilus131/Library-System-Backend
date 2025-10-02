package com.library.management.system.mappers;

import com.library.management.system.data.models.Role;
import com.library.management.system.data.models.User;
import com.library.management.system.dtos.request.UserRequest;
import com.library.management.system.dtos.response.UserResponse;

public class UserMapper {

    public  static User toEntity(UserRequest userRequest){
        User user = new User();

        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(Role.valueOf(userRequest.getRole()));
        return user;
    }

    public static UserResponse toResponse(User user){

        UserResponse userResponse = new UserResponse();

        userResponse.setUserId(user.getUserId());
        userResponse.setUserName(user.getUserName());
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(String.valueOf(user.getRole()));

        return userResponse;
    }
}
