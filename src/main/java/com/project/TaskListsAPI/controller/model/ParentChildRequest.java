package com.project.TaskListsAPI.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@AllArgsConstructor
@Data
public class ParentChildRequest {

    private long parent_id;
    private long child_id;
}
