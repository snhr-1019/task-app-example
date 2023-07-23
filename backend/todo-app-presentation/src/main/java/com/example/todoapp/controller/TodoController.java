package com.example.todoapp.controller;

import com.example.todoapp.api.TodoApi;
import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.model.TodoResponse;
import com.example.todoapp.usecase.ListTodoUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController implements TodoApi {

    @NonNull
    private final ListTodoUseCase listTodo;

    @Override
    public ResponseEntity<List<TodoResponse>> listTodos() {
        var todoList = listTodo.fetch();
        return ResponseEntity.ok(
                todoList.stream()
                        .map(this::fromTodoEntity)
                        .toList()
        );
    }

    public TodoResponse fromTodoEntity(TodoEntity todoEntity) {
        var response = new TodoResponse();
        response.setCode(todoEntity.code().value());
        response.setTitle(todoEntity.title().toString());
        response.setStatus(TodoResponse.StatusEnum.fromValue(todoEntity.status().name()));
        return response;
    }
}
