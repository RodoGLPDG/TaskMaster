package com.rodolfo.taskMaster.dto;

public class AuthResponse {

    private String token ;
    private String name ;
    private String email ;

    public AuthResponse(String token, String email, String name) {
        this.token = token;
        this.email = email;
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
