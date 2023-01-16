package com.example.demo.auth.service;

import com.example.demo.auth.entity.User;

public interface UserService {
    User save(User user) throws Exception;
    User getByUsername(String username);
    void delete(Long id);
}
