package com.library.management.system.services;

import com.library.management.system.dtos.request.UserRequest;
import com.library.management.system.dtos.response.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);
    UserResponse loginUser(UserRequest userRequest);
}
