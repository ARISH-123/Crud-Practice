package com.arish.Crud_Practice.Controller;

import com.arish.Crud_Practice.model.ToDo;
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

    @PostMapping("/add")
    public ToDo addToDo(@RequestBody ToDo toDo)
    {
        return this.toDoService.addTodo(toDo);
    }

    @GetMapping("/todo/{id}")
    public ToDo getToDo(@PathVariable int id)
    {
        return this.toDoService.getTodoById(id);
    }

    @GetMapping("/todos")
    public List<ToDo> getAllTodos()
    {
        return this.toDoService.getAllTodo();
    }

}
