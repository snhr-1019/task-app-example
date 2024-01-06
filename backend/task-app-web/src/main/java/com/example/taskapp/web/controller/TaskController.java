package com.example.taskapp.web.controller;

import com.example.taskapp.domain.entity.TaskEntity;
import com.example.taskapp.usecase.GetTaskUseCase;
import gen.openapi.taskapp.api.TaskApi;
import gen.openapi.taskapp.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController implements TaskApi {

    private final GetTaskUseCase getTaskUseCase;

    private final UserDetailsService userDetailsService;

    @Override
    public ResponseEntity<GetTasksResponse> getTasks() {
        SecurityContext context = SecurityContextHolder.getContext();
        var userDetails = context.getAuthentication().getPrincipal();

        int userId = 1;

        var taskList = getTaskUseCase.fetch(userId);
        return ResponseEntity.ok(
                new GetTasksResponse().tasks(
                        taskList.stream()
                                .map(this::fromTaskEntity)
                                .toList()
                )
        );
    }

    @Override
    public ResponseEntity<CreateTaskResponse> createTask(CreateTaskRequest createTaskRequest) {
        return TaskApi.super.createTask(createTaskRequest);
    }

    @Override
    public ResponseEntity<Void> deleteTask(DeleteTaskRequest deleteTaskRequest) {
        return TaskApi.super.deleteTask(deleteTaskRequest);
    }

    @Override
    public ResponseEntity<Void> updateTask(UpdateTaskRequest updateTaskRequest) {
        return TaskApi.super.updateTask(updateTaskRequest);
    }

    public Task fromTaskEntity(TaskEntity taskEntity) {
        var task = new Task();
        task.setId(taskEntity.getId());
        task.setTitle(taskEntity.getTitle());
        task.setCompleted(taskEntity.isCompleted());
        return task;
    }
}
