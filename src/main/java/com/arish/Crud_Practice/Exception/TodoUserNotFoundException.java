package com.arish.Crud_Practice.Exception;

public class TodoUserNotFoundException extends RuntimeException{

    public TodoUserNotFoundException(Integer userId){
        super("User not found with id: " + userId);
    }
}
