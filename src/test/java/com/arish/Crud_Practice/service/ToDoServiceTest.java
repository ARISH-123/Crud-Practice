package com.arish.Crud_Practice.service;


import com.arish.Crud_Practice.Repository.ToDoRepository;
import com.arish.Crud_Practice.model.ToDo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ToDoServiceTest {
    @Mock
    private ToDoRepository toDoRepository;
    @InjectMocks
    private ToDoService toDoService;

    private ToDo todo;
}
