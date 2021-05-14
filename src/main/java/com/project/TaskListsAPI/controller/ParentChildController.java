package com.project.TaskListsAPI.controller;

import com.project.TaskListsAPI.controller.model.ParentChildRequest;
import com.project.TaskListsAPI.mapper.ParentChildMapper;
import com.project.TaskListsAPI.repository.entity.ParentChild;
import com.project.TaskListsAPI.repository.entity.User;
import com.project.TaskListsAPI.service.ParentChildService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ParentChildController {

    ParentChildService parentChildService;
    ParentChildMapper mapper;

    @PostMapping("/addChild")
    public ResponseEntity<Void> addChild(@RequestBody ParentChildRequest parentChildRequest)
    {
        ParentChild parentChild = mapper.mapParentChildRequestToParentChild(parentChildRequest);
        boolean exist = parentChildService.save(parentChild);

        if(exist)
        {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }





    }
}
