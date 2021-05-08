package com.project.TaskListsAPI.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@Builder
public class TaskRequest {

    private String title;
    private String content;
    private Long user_id;
}
