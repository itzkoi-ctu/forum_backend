package org.example.miniforum.service;

import lombok.extern.slf4j.Slf4j;
import org.example.miniforum.dto.request.UserRequest;
import org.example.miniforum.dto.response.UserResponse;
import org.example.miniforum.mapper.UserMapper;
import org.example.miniforum.model.User;
import org.example.miniforum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponse createUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);

        return userMapper.toUserResponse(userRepository.save(user));
    }
}
