package com.project.TaskListsAPI.service;

import com.project.TaskListsAPI.controller.dto.UserRequest;
import com.project.TaskListsAPI.controller.dto.UserResponse;
import com.project.TaskListsAPI.repository.UserRepository;
import com.project.TaskListsAPI.repository.entity.User;
import com.project.TaskListsAPI.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public void save(UserRequest userRequest)
    {
        User user = mapper.mapUserRequestToUser(userRequest, passwordEncoder);
        userRepository.save(user);
    }


    public UserResponse findById(Long id)
    {

        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("This User does not exists"));
        UserResponse userResponse = mapper.mapUsertoUserResponse(user);
        return userResponse;
    }
}
