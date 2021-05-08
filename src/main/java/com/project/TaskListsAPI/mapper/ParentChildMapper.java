package com.project.TaskListsAPI.mapper;

import com.project.TaskListsAPI.controller.model.ParentChildRequest;
import com.project.TaskListsAPI.repository.entity.ParentChild;
import org.springframework.stereotype.Component;

@Component
public class ParentChildMapper {

    public ParentChild mapParentChildRequestToParentChild(ParentChildRequest parentChildRequest)
    {
        return ParentChild.builder()
                .parent_id(parentChildRequest.getParent_id())
                .child_id(parentChildRequest.getChild_id())
                .build();
    }
}
