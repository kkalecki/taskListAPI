package com.project.TaskListsAPI.mapper;

import com.project.TaskListsAPI.controller.model.UserRequest;
import com.project.TaskListsAPI.controller.model.UserRequestLogin;
import com.project.TaskListsAPI.controller.model.UserResponse;
import com.project.TaskListsAPI.repository.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public User mapUserRequestToUser(UserRequest userRequest)
    {
        User user = User.builder()
                .username(userRequest.getUsername())
                .password((userRequest.getPassword()))
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
    public User mapUserRequestLoginToUser(UserRequestLogin userRequestLogin)
    {
        User user = User.builder()
                .username(userRequestLogin.getUsername())
                .password((userRequestLogin.getPassword()))
                .build();
        return user;
    }




}
