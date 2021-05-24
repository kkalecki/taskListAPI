package com.project.TaskListsAPI.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TaskUpdateRequest {

    private long id;
    private String title;
    private String content;
}
