package com.project.TaskListsAPI.controller;

import com.project.TaskListsAPI.controller.dto.UserRequest;
import com.project.TaskListsAPI.controller.dto.UserResponse;
import com.project.TaskListsAPI.repository.entity.User;
import com.project.TaskListsAPI.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    UserService userService;

    @PostMapping("/user")
    public void save(@RequestBody UserRequest userRequest) {
        userService.save(userRequest);
    }

    @GetMapping("/user")
    public UserResponse findById(@RequestParam Long id) {
        return userService.findById(id);
    }
    @PostMapping("hello")
    public String sayHello()
    {
        return "Hello my friend!";
    }


}
