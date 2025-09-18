package com.library.management.system.dtos.request;


@lombok.Data
public class UserRequest {
    private String userName;
    private String password;
    private String role;
}
