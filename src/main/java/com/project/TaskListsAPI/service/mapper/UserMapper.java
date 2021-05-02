package com.project.TaskListsAPI.service.mapper;

import com.project.TaskListsAPI.controller.dto.UserRequest;
import com.project.TaskListsAPI.controller.dto.UserResponse;
import com.project.TaskListsAPI.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public User mapUserRequestToUser(UserRequest userRequest,PasswordEncoder passwordEncoder)
    {
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(userRequest.getRole())
                .build();
        return user;
    }
    public UserResponse mapUsertoUserResponse(User user)
    {
        UserResponse userResponse = UserResponse.builder()
                .username(user.getUsername())
                .parents(user.getParents())
                .children(user.getChildren())
                .tasks(user.getTasks())
                .build();
        return userResponse;
    }




}
