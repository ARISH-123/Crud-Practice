package com.arish.Crud_Practice.Controller;

import com.arish.Crud_Practice.dto.ToDoDTO;
import com.arish.Crud_Practice.dto.ToDoUserDTO;
import com.arish.Crud_Practice.model.ToDo;
import com.arish.Crud_Practice.response.ToDoResponse;
import com.arish.Crud_Practice.service.ToDoService;
import org.springframework.web.bind.annotation.*;

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
        return convertToResponse(toDo);
    }

    @GetMapping("/todos")
    public List<ToDo> getAllTodos()
    {
        return this.toDoService.getAllTodo();
    }

    @DeleteMapping("/todo/{id}")
    public ToDo  deleteTodo(@PathVariable int id)
    {
        return this.toDoService.deleteTodo(id);
    }


    public ToDoResponse convertToResponse(ToDo toDo)
    {
        ToDoResponse toDoResponse = new ToDoResponse();
        toDoResponse.setId(toDo.getId());
        toDoResponse.setTitle(toDo.getTitle());
        toDoResponse.setDescription(toDo.getDescription());
        if(toDo.getUser()==null)
        {
            throw new RuntimeException("User is null");
        }
        ToDoUserDTO user = new ToDoUserDTO(toDo.getUser().getId(),toDo.getUser().getName(),toDo.getUser().getEmail());
        toDoResponse.setUser(user);
        return toDoResponse;
    }


}
