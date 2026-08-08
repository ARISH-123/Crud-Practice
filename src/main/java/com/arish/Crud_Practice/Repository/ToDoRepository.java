package com.arish.Crud_Practice.Repository;


import com.arish.Crud_Practice.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Integer> {
}
