package com.arish.Crud_Practice.Exception;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(int id){
        super("Todo not found with id " + id);
    }
}
