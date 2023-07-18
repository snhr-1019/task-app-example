package com.example.todoapp.usecase;

import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.domain.repository.TodoRepository;
import com.example.todoapp.domain.vo.Code;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListTodoUseCase {

    private final TodoRepository todoRepository;

    public List<TodoEntity> fetch() {
        return todoRepository.fetch();
    }
}
