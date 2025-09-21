package com.library.management.system.dtos.request;


@lombok.Data
public class UserRequest {

    private String userName;
    private String email;
    private String password;
    private String role;
}
