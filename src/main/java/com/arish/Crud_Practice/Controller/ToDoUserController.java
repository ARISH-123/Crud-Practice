package com.arish.Crud_Practice.Controller;

import com.arish.Crud_Practice.Exception.TodoUserNotFoundException;
import com.arish.Crud_Practice.dto.ToDoDTO;
import com.arish.Crud_Practice.dto.ToDoUserDTO;
import com.arish.Crud_Practice.model.ToDoUser;
import com.arish.Crud_Practice.response.ToDoUserResponse;
import com.arish.Crud_Practice.service.ToDoUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoUserController {

    private final ToDoUserService toDoUserService;
    private List<ToDoUserDTO> todos;

    private ToDoUserController(ToDoUserService toDoUserService) {
        this.toDoUserService = toDoUserService;
    }

    @PostMapping("/add-user")
    public ToDoUser addUser(@RequestBody ToDoUser toDoUser) {
        return toDoUserService.addUser(toDoUser);
    }

    @GetMapping("/users")
    public List<ToDoUserDTO> getUsers() {

        return toDoUserService.getUsers().stream().map(todo -> new ToDoUserDTO(todo.getId(), todo.getName(), todo.getEmail())).toList();

    }

    @GetMapping("/user/{id}")
    public ToDoUserResponse getUserById(@PathVariable int id) {

        ToDoUser user = toDoUserService.getUser(id);
        return convertToUserResponse(user);
    }

    @GetMapping("/user-todo/{userId}")
    public List<ToDoDTO> getTodosByUser(@PathVariable int userId) {
        ToDoUser user = toDoUserService.getUser(userId);
        return user.getTodos().stream().map(todo -> new ToDoDTO(todo.getId(), todo.getTitle(), todo.getDescription())).toList();
    }

    public ToDoUserResponse convertToUserResponse(ToDoUser user) {
        ToDoUserResponse toDoUserResponse = new ToDoUserResponse();
        toDoUserResponse.setId(user.getId());
        toDoUserResponse.setName(user.getName());
        toDoUserResponse.setEmail(user.getEmail());
        List<ToDoDTO> toDoDTOS = user.getTodos().stream()
                .map(toDo -> new ToDoDTO(
                        toDo.getId(),
                        toDo.getTitle(),
                        toDo.getDescription()
                ))
                .toList();
        toDoUserResponse.setTodos(toDoDTOS);
        return toDoUserResponse;
    }
}
