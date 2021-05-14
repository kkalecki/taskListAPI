package com.project.TaskListsAPI.controller;

import com.project.TaskListsAPI.controller.model.*;
import com.project.TaskListsAPI.mapper.TaskMapper;
import com.project.TaskListsAPI.mapper.UserMapper;
import com.project.TaskListsAPI.repository.TaskRepository;
import com.project.TaskListsAPI.repository.entity.Task;
import com.project.TaskListsAPI.repository.entity.User;
import com.project.TaskListsAPI.service.TaskService;
import com.project.TaskListsAPI.service.TokenUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(value = "*")
public class TaskController {

    public TaskService taskService;
    public TaskMapper mapper;

    @GetMapping("/task")
    ResponseEntity<List<TaskResponse>> findAllByUser_id(@RequestParam Long user_id)
    {
        List<Task> tasks = taskService.findAllByUser_id(user_id);
        List<TaskResponse> taskResponses = mapper.mapTasksToTaskResponses(tasks);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponses);
    }

    @PostMapping("/task")
    public ResponseEntity<Void> save(@RequestBody TaskRequest taskRequest)
    {
        System.out.println("taskRequest w controller: "+taskRequest);
        Task task = mapper.mapTaskRequestToTask(taskRequest);
        System.out.println("task w controller:"+task);
        taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/task")
    public ResponseEntity<List<TaskResponse>> deleteTaskById(@RequestParam Long task_id)
    {
        taskService.deleteById(task_id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
