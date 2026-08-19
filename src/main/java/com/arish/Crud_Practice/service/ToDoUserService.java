package com.arish.Crud_Practice.service;

import com.arish.Crud_Practice.Repository.ToDoUserRepository;
import com.arish.Crud_Practice.model.ToDoUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoUserService {

   private final ToDoUserRepository toDoUserRepository;
   private static final Logger log = LoggerFactory.getLogger(ToDoUserService.class.getName());

   public ToDoUserService(ToDoUserRepository toDoUserRepository) {
       this.toDoUserRepository = toDoUserRepository;
   }

   public ToDoUser addUser(ToDoUser toDoUser) {
       log.info("In addUser function");
       log.info("User name:{}",toDoUser.getName());
       return toDoUserRepository.save(toDoUser);
   }

   public List<ToDoUser> getUsers() {
       return toDoUserRepository.findAll();
   }

    public ToDoUser getUser(int id) {
       return toDoUserRepository.findById(id).get();
    }
}


