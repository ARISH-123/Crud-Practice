package com.arish.Crud_Practice.service;

import com.arish.Crud_Practice.Exception.TodoNotFoundException;
import com.arish.Crud_Practice.Exception.TodoUserNotFoundException;
import com.arish.Crud_Practice.Repository.ToDoRepository;
import com.arish.Crud_Practice.Repository.ToDoUserRepository;
import com.arish.Crud_Practice.model.ToDo;
import com.arish.Crud_Practice.model.ToDoUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final ToDoUserRepository toDoUserRepository;
    public ToDoService(ToDoRepository toDoRepository,  ToDoUserRepository toDoUserRepository) {
        this.toDoRepository = toDoRepository;
        this.toDoUserRepository = toDoUserRepository;
    }


    public ToDo addTodo(Integer userId, ToDo toDo)
    {

        ToDoUser user = toDoUserRepository.findById(userId).orElseThrow(()-> new TodoUserNotFoundException(userId));
        toDo.setUser(user);
        toDoRepository.save(toDo);
        Optional<ToDo> toDoResult = toDoRepository.findById(toDo.getId());
        return toDoResult.orElse(null);
    }


    public ToDo getTodoById(int id)
    {
        return toDoRepository.findById(id)
            .orElseThrow(() -> new TodoNotFoundException(id));
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
