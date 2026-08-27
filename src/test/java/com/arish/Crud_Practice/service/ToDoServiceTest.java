package com.arish.Crud_Practice.service;


import com.arish.Crud_Practice.Repository.ToDoRepository;
import com.arish.Crud_Practice.model.ToDo;
import com.arish.Crud_Practice.model.ToDoUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ToDoServiceTest {
    @Mock
    private ToDoRepository toDoRepository;
    @InjectMocks
    private ToDoService toDoService;

    private ToDo todo;


    @BeforeEach
    void setUp() {
        todo = new ToDo(
                1,
                "Todo1",
                "description of todo 1"
        );


    }

    @Test
    void testGetToDo(){
        int id=1;
        when (toDoRepository.findById(id)).thenReturn(Optional.of(todo));
        ToDo currentToDo = toDoService.getTodoById(id);
        assertNotNull(currentToDo);
        assertEquals("Todo1", currentToDo.getTitle());
        verify(toDoRepository, times(1)).findById(id);
    }
}
