package com.project.TaskListsAPI.service;

import com.project.TaskListsAPI.repository.ParentChildRepository;
import com.project.TaskListsAPI.repository.UserRepository;
import com.project.TaskListsAPI.repository.entity.ParentChild;
import com.project.TaskListsAPI.repository.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ParentChildService {

    ParentChildRepository parentChildRepository;
    UserRepository userRepository;

    public boolean save(ParentChild parentChild)
    {
        Optional<User> checkIfUserExist = userRepository.findById(parentChild.getChild_id());
        if(checkIfUserExist.isEmpty())
        {
            return false;
        }
        else if(checkIfUserExist.get().getRole().equals("CHILD"))
        {
            parentChildRepository.save(parentChild);
            return true;
        }
        else
        {
            return false;
        }


    }
}
