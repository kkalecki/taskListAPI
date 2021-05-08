package com.project.TaskListsAPI.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserRequestLogin {

    private String username;
    private String password;
}
