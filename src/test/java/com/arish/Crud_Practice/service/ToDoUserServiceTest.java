package com.arish.Crud_Practice.service;

import com.arish.Crud_Practice.Repository.ToDoUserRepository;
import com.arish.Crud_Practice.model.ToDoUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ToDoUserServiceTest {

    @Mock
    private ToDoUserRepository toDoUserRepository;


    @InjectMocks
    private ToDoUserService toDoUserService;

    private ToDoUser user;

    @BeforeEach
    void setUp() {
        user = new ToDoUser(
                1,
                "Arish",
                "arish@gmail.com"
        );
    }

    @Test
    void testAddUser() {

        when(toDoUserRepository.save(user))
                .thenReturn(user);

        ToDoUser savedUser = toDoUserService.addUser(user);

        assertNotNull(savedUser);
        assertEquals(1, savedUser.getId());
        assertEquals("Arish", savedUser.getName());

        verify(toDoUserRepository, times(1))
                .save(user);
    }

    @Test
    void testGetUsers() {

        List<ToDoUser> users = Arrays.asList(
                user,
                new ToDoUser(
                        2,
                        "John",
                        "john@test.com"
                )
        );

        when(toDoUserRepository.findAll())
                .thenReturn(users);

        List<ToDoUser> result = toDoUserService.getUsers();

        assertEquals(2, result.size());

        verify(toDoUserRepository, times(1))
                .findAll();
    }

    @Test
    void testGetUser(){
        int id=1;
        when (toDoUserRepository.findById(id)).thenReturn(Optional.of(user));
        ToDoUser currentUser = toDoUserService.getUser(id);
        assertNotNull(currentUser);
        assertEquals("Arish", currentUser.getName());
        verify(toDoUserRepository, times(1)).findById(id);
    }
}
