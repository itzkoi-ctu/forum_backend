package org.example.miniforum.controller;

import org.example.miniforum.dto.request.UserRequest;
import org.example.miniforum.dto.response.UserResponse;
import org.example.miniforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
