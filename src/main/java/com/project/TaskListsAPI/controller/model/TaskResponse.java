package com.project.TaskListsAPI.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@Builder
public class TaskResponse {

    private Long id;
    private String title;
    private String content;
}
