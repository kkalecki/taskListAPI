package com.project.TaskListsAPI.service;

import com.project.TaskListsAPI.repository.TaskRepository;
import com.project.TaskListsAPI.repository.entity.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    public TaskRepository taskRepository;

    public void save(Task task)
    {
        taskRepository.save(task);
    }

    public List<Task> findAllByUser_id(Long user_id)
    {
        return taskRepository.findAllByUserId(user_id);
    }
}
