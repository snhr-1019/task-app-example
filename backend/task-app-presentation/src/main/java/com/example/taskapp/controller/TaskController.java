package com.example.taskapp.controller;

import com.example.taskapp.api.TaskApi;
import com.example.taskapp.domain.entity.TaskEntity;
import com.example.taskapp.model.TaskResponse;
import com.example.taskapp.usecase.ListTaskUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController implements TaskApi {

    @NonNull
    private final ListTaskUseCase listTask;

    @Override
    public ResponseEntity<List<TaskResponse>> listTasks() {
        var taskList = listTask.fetch();
        return ResponseEntity.ok(
                taskList.stream()
                        .map(this::fromTaskEntity)
                        .toList()
        );
    }

    public TaskResponse fromTaskEntity(TaskEntity taskEntity) {
        var response = new TaskResponse();
        response.setCode(taskEntity.code().value());
        response.setTitle(taskEntity.title().toString());
        response.setStatus(TaskResponse.StatusEnum.fromValue(taskEntity.status().name()));
        return response;
    }
}
