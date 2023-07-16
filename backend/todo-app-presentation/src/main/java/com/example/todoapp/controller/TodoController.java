package com.example.todoapp.controller;

import com.example.todoapp.api.TodoApi;
import com.example.todoapp.model.TodoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController implements TodoApi {

    @Override
    public ResponseEntity<List<TodoResponse>> listTodos() {
        var todoList = List.of(new TodoResponse()
                .code("ABC123")
                .title("牛乳を買う")
                .status(TodoResponse.StatusEnum.TODO)
        );
        return new ResponseEntity<>(
                todoList,
                HttpStatus.OK
        );
    }
}
