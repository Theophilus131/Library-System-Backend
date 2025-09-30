package com.library.management.system.data.models;


import org.springframework.data.annotation.Id;

@lombok.Data
public class User {

    @Id
    private String userId;
    private String userName;
    private String email;
    private String password;

    private Role role;
}
