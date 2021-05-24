package com.project.TaskListsAPI.repository;

import com.project.TaskListsAPI.repository.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Override
    <S extends Task> S save(S s);

    @Query("select t from Task t where t.user_id = ?1")
    List<Task> findAllByUserId(Long user_id);

    @Override
    void deleteById(Long task_id);

    @Override
    Optional<Task> findById(Long aLong);
}
