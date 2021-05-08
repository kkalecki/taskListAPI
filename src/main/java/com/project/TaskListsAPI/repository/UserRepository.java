package com.project.TaskListsAPI.repository;

import com.project.TaskListsAPI.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    @Override
    List<User> findAll();

    @Override
    <S extends User> S save(S s);

    @Override
    Optional<User> findById(Long aLong);


}
