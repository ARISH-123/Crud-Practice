package com.arish.Crud_Practice.Controller;

import com.arish.Crud_Practice.dto.ToDoDTO;
import com.arish.Crud_Practice.dto.ToDoUserDTO;
import com.arish.Crud_Practice.model.ToDo;
import com.arish.Crud_Practice.response.ToDoResponse;
import com.arish.Crud_Practice.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping("/add/{userId}")
    public ToDoDTO addToDo(@PathVariable Integer userId, @RequestBody ToDo toDo)
    {
        ToDo todo =  this.toDoService.addTodo(userId,toDo);
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setId(todo.getId());
        toDoDTO.setDescription(todo.getDescription());
        toDoDTO.setTitle(todo.getTitle());
        return toDoDTO;
    }

    @GetMapping("/todo/{id}")
    public ToDoResponse getToDo(@PathVariable int id)
    {
        ToDo toDo =  this.toDoService.getTodoById(id);
        return convertToToDoResponse(toDo);
    }

    @GetMapping("/todos")
    public List<ToDoDTO> getAllTodos()
    {
        List<ToDo> todos =  this.toDoService.getAllTodo();
        return todos.stream().map(todo->new ToDoDTO(todo.getId(),todo.getTitle(),todo.getDescription())).toList();
    }

    @DeleteMapping("/todo/{id}")
    public ToDo  deleteTodo(@PathVariable int id)
    {
        return this.toDoService.deleteTodo(id);
    }


    public ToDoResponse convertToToDoResponse(ToDo toDo)
    {
        ToDoResponse toDoResponse = new ToDoResponse();
        toDoResponse.setId(toDo.getId());
        toDoResponse.setTitle(toDo.getTitle());
        toDoResponse.setDescription(toDo.getDescription());
        ToDoUserDTO user = new ToDoUserDTO(toDo.getUser().getId(),toDo.getUser().getName(),toDo.getUser().getEmail());
        toDoResponse.setUser(user);
        return toDoResponse;
    }


}
