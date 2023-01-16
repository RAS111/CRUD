package com.example.demo.auth.controller;

import com.example.demo.auth.entity.User;
import com.example.demo.auth.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/")
    public User save(@RequestBody User user) throws Exception{
        return this.userService.save(user);
    }

    @GetMapping("/{username}")
    public User getByUsername(@PathVariable String username){
        return this.userService.getByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.userService.delete(id);
    }

}
