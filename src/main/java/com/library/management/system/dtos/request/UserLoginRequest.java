package com.library.management.system.dtos.request;

@lombok.Data
public class UserLoginRequest {
    private String password;
    private String email;

}
