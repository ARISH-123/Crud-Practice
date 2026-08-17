package com.arish.Crud_Practice.response;

import com.arish.Crud_Practice.dto.ToDoDTO;
import com.arish.Crud_Practice.model.ToDo;

import java.util.List;

public class ToDoUserResponse {
    private Integer id;
    private String name;
    private String email;
    private List<ToDoDTO> todos;

    public ToDoUserResponse() {}

    public ToDoUserResponse(Integer id, String name, String email, List<ToDoDTO> todos) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.todos = todos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ToDoDTO> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDoDTO> todos) {
        this.todos = todos;
    }
}
