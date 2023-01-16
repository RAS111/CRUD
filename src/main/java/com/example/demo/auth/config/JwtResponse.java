package com.example.demo.auth.config;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtResponse {

    private String token;

    public JwtResponse() {
    }

    public JwtResponse(String token) {
        this.token = token;
    }

}
