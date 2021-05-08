package com.project.TaskListsAPI.mapper;

import com.project.TaskListsAPI.controller.model.TaskRequest;
import com.project.TaskListsAPI.controller.model.TaskResponse;
import com.project.TaskListsAPI.controller.model.UserRequest;
import com.project.TaskListsAPI.repository.entity.Task;
import com.project.TaskListsAPI.repository.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public Task mapTaskRequestToTask(TaskRequest taskRequest)
    {
        Task task = Task.builder()
                .title(taskRequest.getTitle())
                .content(taskRequest.getContent())
                .user_id(taskRequest.getUser_id())
                .build();
        return task;
    }
    public List<TaskResponse> mapTasksToTaskResponses(List<Task> tasks)
    {
        List<TaskResponse> taskResponses = tasks.stream().map(task -> TaskResponse.builder()
                .title(task.getTitle())
                .content(task.getContent())
                .build()).collect(Collectors.toList());
        return taskResponses;
    }
}
