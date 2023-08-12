package com.example.taskapp.usecase;

import com.example.taskapp.domain.entity.TaskEntity;
import com.example.taskapp.domain.repository.TaskRepository;
import com.example.taskapp.domain.vo.Code;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListTaskUseCase {

    private final TaskRepository taskRepository;

    public List<TaskEntity> fetch() {
        return taskRepository.fetch();
    }
}
