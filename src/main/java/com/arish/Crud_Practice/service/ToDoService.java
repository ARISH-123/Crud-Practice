package com.arish.Crud_Practice.service;

import com.arish.Crud_Practice.Repository.ToDoRepository;
import com.arish.Crud_Practice.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    public ToDo addTodo(ToDo toDo)
    {
        toDoRepository.save(toDo);
        Optional<ToDo> toDoResult = toDoRepository.findById(toDo.getId());
        return toDoResult.orElse(null);
    }


    public ToDo getTodoById(int id)
    {
        return toDoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
    }

    public List<ToDo> getAllTodo()
    {
        return toDoRepository.findAll();
    }

    public ToDo deleteTodo(int id)
    {
        ToDo deletedTodo = getTodoById(id);
         toDoRepository.delete(deletedTodo);
         return deletedTodo;
    }

}
