package com.example.taskapp.usecase;

import com.example.taskapp.domain.entity.TaskEntity;
import com.example.taskapp.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateTaskUseCase {
    private final TaskRepository taskRepository;

    public TaskEntity createTask(int userId, String title) {
        var taskEntity = TaskEntity.createNewTaskEntity(userId, title);
        return taskRepository.create(taskEntity);
    }
}
