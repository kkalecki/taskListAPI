package com.project.TaskListsAPI.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {

    private String username;
    private String password;
    private String role;
}
