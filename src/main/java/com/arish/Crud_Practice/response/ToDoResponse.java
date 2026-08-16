package com.arish.Crud_Practice.response;

import com.arish.Crud_Practice.dto.ToDoUserDTO;

public class ToDoResponse {
    private Integer id;
    private String title;
    private String description;
    private ToDoUserDTO user;

    public ToDoResponse() {
    }

    public ToDoResponse(Integer id, String title, String description, ToDoUserDTO user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ToDoUserDTO getUser() {
        return user;
    }

    public void setUser(ToDoUserDTO user) {
        this.user = user;
    }
}
