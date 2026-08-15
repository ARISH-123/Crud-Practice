package com.arish.Crud_Practice.Controller;

import com.arish.Crud_Practice.dto.ToDoUserDTO;
import com.arish.Crud_Practice.model.ToDoUser;
import com.arish.Crud_Practice.service.ToDoUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoUserController {

    private final ToDoUserService toDoUserService;

    private ToDoUserController(ToDoUserService toDoUserService) {
        this.toDoUserService = toDoUserService;
    }

    @PostMapping("/add-user")
    public ToDoUser addUser(@RequestBody ToDoUser toDoUser) {
        return toDoUserService.addUser(toDoUser);
    }

    @GetMapping("/users")
    public List<ToDoUser> getUsers(){
        return toDoUserService.getUsers();
    }

    @GetMapping("/user/{id}")
    public ToDoUserDTO getUserById(@PathVariable int id){
        ToDoUserDTO toDoUserDTO = new ToDoUserDTO();
        ToDoUser user =  toDoUserService.getUser(id);
        toDoUserDTO.setId(user.getId());
        toDoUserDTO.setName(user.getName());
        toDoUserDTO.setEmail(user.getEmail());
        return toDoUserDTO;
    }
}
