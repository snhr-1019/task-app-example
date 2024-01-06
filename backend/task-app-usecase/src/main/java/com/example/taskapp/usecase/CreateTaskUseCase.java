package com.example.taskapp.usecase;

import com.example.taskapp.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateTaskUseCase {
    private final TaskRepository taskRepository;

    public void createTask() {
//        taskRepository.create();
        System.out.println("createTask");
    }
}
