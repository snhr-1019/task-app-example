package com.example.taskapp.usecase;

import com.example.taskapp.domain.entity.TodoEntity;
import com.example.taskapp.domain.repository.TodoRepository;
import com.example.taskapp.domain.vo.Code;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListTodoUseCase {

    private final TodoRepository taskRepository;

    public List<TodoEntity> fetch() {
        return taskRepository.fetch();
    }
}
