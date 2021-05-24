package com.project.TaskListsAPI.service;

import com.project.TaskListsAPI.repository.TaskRepository;
import com.project.TaskListsAPI.repository.entity.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    public TaskRepository taskRepository;

    public void save(Task task)
    {
        System.out.println(task);
        taskRepository.save(task);
    }

    public List<Task> findAllByUser_id(Long user_id)
    {
        return taskRepository.findAllByUserId(user_id);
    }

    public void deleteById(Long task_id)
    {
        taskRepository.deleteById(task_id);
    }

    public void update(Task task) {

        System.out.println(task);
        taskRepository.save(task);
    }

    public Task findById(Long id)
    {
        return taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User Not Found"));
    }
}
