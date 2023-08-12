package com.example.taskapp.controller;

import com.example.taskapp.api.TodoApi;
import com.example.taskapp.domain.entity.TodoEntity;
import com.example.taskapp.model.TodoResponse;
import com.example.taskapp.usecase.ListTodoUseCase;
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
        var taskList = listTodo.fetch();
        return ResponseEntity.ok(
                taskList.stream()
                        .map(this::fromTodoEntity)
                        .toList()
        );
    }

    public TodoResponse fromTodoEntity(TodoEntity taskEntity) {
        var response = new TodoResponse();
        response.setCode(taskEntity.code().value());
        response.setTitle(taskEntity.title().toString());
        response.setStatus(TodoResponse.StatusEnum.fromValue(taskEntity.status().name()));
        return response;
    }
}
