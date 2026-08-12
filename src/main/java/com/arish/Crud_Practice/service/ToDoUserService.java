package com.arish.Crud_Practice.service;

import com.arish.Crud_Practice.Repository.ToDoUserRepository;
import com.arish.Crud_Practice.model.ToDoUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoUserService {

   private final ToDoUserRepository toDoUserRepository;

   public ToDoUserService(ToDoUserRepository toDoUserRepository) {
       this.toDoUserRepository = toDoUserRepository;
   }

   public ToDoUser addUser(ToDoUser toDoUser) {
       return toDoUserRepository.save(toDoUser);
   }

   public List<ToDoUser> getUsers() {
       return toDoUserRepository.findAll();
   }
}


