package com.arish.Crud_Practice.Controller;

import com.arish.Crud_Practice.model.ToDo;
import com.arish.Crud_Practice.service.ToDoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping("/add")
    public ToDo addToDo(@RequestBody ToDo toDo)
    {
        return this.toDoService.addTodo(toDo);
    }

}
