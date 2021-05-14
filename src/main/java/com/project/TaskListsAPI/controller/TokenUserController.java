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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin(value = "*")
public class TokenUserController {

    public TokenUserService userService;
    public UserMapper mapper;


    @PostMapping("/user")
    public ResponseEntity<Void> save(@RequestBody UserRequest userRequest) {

            User user = mapper.mapUserRequestToUser(userRequest);
            boolean notExist = userService.save(user);
            if(notExist)
            {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }



    }
    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody UserRequestLogin userRequestLogin)
    {

        User user = mapper.mapUserRequestLoginToUser(userRequestLogin);
        Token token = userService.login(user);
        if(token.isUserExists() && token.isParent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(token);
        }
        else if(token.isUserExists() && !token.isParent())
        {

            return ResponseEntity.status(HttpStatus.OK).body(token);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @GetMapping("/user")
    public ResponseEntity<User> findByUsername(@RequestParam String username)
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByUsername(username));
    }
    @GetMapping("/children")
    public ResponseEntity<List<String>> findChildrenNames(@RequestParam String username)
    {
        List<String> childrenNames = userService.findChildrenNames(username);
        return ResponseEntity.status(HttpStatus.OK).body(childrenNames);

    }

}
