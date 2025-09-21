package com.library.management.system.data.models;


import org.springframework.data.annotation.Id;

@lombok.Data
public class User {

    @Id
    private String UserId;
    private String UserName;
    private String Email;
    private String Password;

    private Role role;
}
