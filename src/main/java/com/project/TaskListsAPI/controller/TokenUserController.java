package com.project.TaskListsAPI.controller;

import com.project.TaskListsAPI.controller.model.UserRequest;
import com.project.TaskListsAPI.controller.model.Token;
import com.project.TaskListsAPI.controller.model.UserRequestLogin;
import com.project.TaskListsAPI.mapper.UserMapper;
import com.project.TaskListsAPI.repository.entity.User;
import com.project.TaskListsAPI.service.TokenUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(value = "*")
public class TokenUserController {

    public TokenUserService userService;
    public UserMapper mapper;


    @PostMapping("/user")
    public ResponseEntity<Void> save(@RequestBody UserRequest userRequest) {
        User user = mapper.mapUserRequestToUser(userRequest);
        userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody UserRequestLogin userRequestLogin)
    {
        User user = mapper.mapUserRequestLoginToUser(userRequestLogin);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.login(user));
    }
    @GetMapping("/user")
    public ResponseEntity<User> findByUsername(@RequestParam String username)
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByUsername(username));
    }

}
