package com.arish.Crud_Practice.service;

import com.arish.Crud_Practice.Repository.ToDoUserRepository;
import com.arish.Crud_Practice.model.ToDoUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomToDoUserDetailsService implements UserDetailsService {

    private final ToDoUserRepository toDoUserRepository;

    CustomToDoUserDetailsService(ToDoUserRepository toDoUserRepository) {
        this.toDoUserRepository = toDoUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ToDoUser user = toDoUserRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getEmail(),
                new ArrayList<>()
        );
    }
}
