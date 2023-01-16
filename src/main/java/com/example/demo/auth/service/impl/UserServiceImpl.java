package com.example.demo.auth.service.impl;

import com.example.demo.auth.entity.User;
import com.example.demo.auth.repository.UserRepository;
import com.example.demo.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) throws Exception {
        User userSearch = this.userRepository.findByUsername(user.getUsername());
        if (userSearch != null){
            throw new Exception("el usuario ya existe");
        } else {
            userSearch =  this.userRepository.save(user);
        }
        return userSearch;
    }

    @Override
    public User getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}
