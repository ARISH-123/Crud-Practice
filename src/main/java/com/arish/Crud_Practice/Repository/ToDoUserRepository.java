package com.arish.Crud_Practice.Repository;

import com.arish.Crud_Practice.model.ToDoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDoUserRepository extends JpaRepository<ToDoUser, Integer> {
    Optional<ToDoUser> findByName(String username);
}
