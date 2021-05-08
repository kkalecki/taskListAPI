package com.project.TaskListsAPI.service;

import com.project.TaskListsAPI.repository.ParentChildRepository;
import com.project.TaskListsAPI.repository.entity.ParentChild;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParentChildService {

    ParentChildRepository parentChildRepository;

    public void save(ParentChild parentChild)
    {
        parentChildRepository.save(parentChild);
    }
}
