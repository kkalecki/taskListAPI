package com.project.TaskListsAPI.repository;

import com.project.TaskListsAPI.repository.entity.ParentChild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentChildRepository extends JpaRepository<ParentChild,Long> {

    @Override
    <S extends ParentChild> S save(S s);
}
