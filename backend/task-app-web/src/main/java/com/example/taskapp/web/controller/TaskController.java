package com.example.taskapp.web.controller;

import com.example.taskapp.domain.entity.TaskEntity;
import com.example.taskapp.usecase.GetTaskUseCase;
import gen.openapi.taskapp.api.TaskApi;
import gen.openapi.taskapp.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class TaskController implements TaskApi {

    private final GetTaskUseCase getTaskUseCase;

    @Override
    public ResponseEntity<GetTasksResponse> getTasks() {
        var taskList = getTaskUseCase.fetch();
        return ResponseEntity.ok(
                new GetTasksResponse().tasks(
                        taskList.stream()
                                .map(this::fromTaskEntity)
                                .toList()
                )
        );
    }

    @Override
    public ResponseEntity<Void> createTask(CreateTaskInput createTaskInput) {
        return TaskApi.super.createTask(createTaskInput);
    }

    @Override
    public ResponseEntity<Void> deleteTask(DeleteTaskInput deleteTaskInput) {
        return TaskApi.super.deleteTask(deleteTaskInput);
    }

    @Override
    public ResponseEntity<Void> updateTask(UpdateTaskInput updateTaskInput) {
        return TaskApi.super.updateTask(updateTaskInput);
    }


    public Task fromTaskEntity(TaskEntity taskEntity) {
        var task = new Task();
        task.setId(taskEntity.id().value());
        task.setTitle(taskEntity.title().value());
        task.setCompleted(taskEntity.completed());
        return task;
    }
}
