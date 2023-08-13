package com.example.taskapp.controller;

import com.example.taskapp.api.TasksApi;
import com.example.taskapp.domain.entity.TaskEntity;
import com.example.taskapp.model.GetTasksResponse;
import com.example.taskapp.model.PostTaskRequest;
import com.example.taskapp.model.PutTaskRequest;
import com.example.taskapp.model.Task;
import com.example.taskapp.usecase.ListTaskUseCase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class TasksController implements TasksApi {

    @NonNull
    private final ListTaskUseCase listTask;

    @Override
    public ResponseEntity<GetTasksResponse> getTasks() {
        var taskList = listTask.fetch();
        return ResponseEntity.ok(
                new GetTasksResponse().tasks(
                        taskList.stream()
                                .map(this::fromTaskEntity)
                                .toList()
                )
        );
    }

    @Override
    public ResponseEntity<Task> postTask(Task task) {
        return TasksApi.super.postTask(task);
    }

    @Override
    public ResponseEntity<Task> putTask(BigDecimal taskId, PutTaskRequest putTaskRequest) {
        return TasksApi.super.putTask(taskId, putTaskRequest);
    }

    @Override
    public ResponseEntity<Void> deleteTask(BigDecimal taskId) {
        return TasksApi.super.deleteTask(taskId);
    }

    public Task fromTaskEntity(TaskEntity taskEntity) {
        var task = new Task();
        task.setId(taskEntity.id().value());
        task.setTitle(taskEntity.title().value());
        task.setCompleted(taskEntity.completed());
        return task;
    }
}
