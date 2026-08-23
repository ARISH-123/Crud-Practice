package com.arish.Crud_Practice.service;

import com.arish.Crud_Practice.Repository.ToDoUserRepository;
import com.arish.Crud_Practice.model.ToDoUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
}
