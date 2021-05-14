package com.project.TaskListsAPI.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Token {
    private String token;
    private boolean userExists;
    private boolean isParent;
}
