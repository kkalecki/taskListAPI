package com.project.TaskListsAPI.controller.dto;


import com.project.TaskListsAPI.repository.entity.Task;
import com.project.TaskListsAPI.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class UserResponse {

    String username;
    private List<User> parents;
    private List<User> children;
    private List<Task> tasks;
}
