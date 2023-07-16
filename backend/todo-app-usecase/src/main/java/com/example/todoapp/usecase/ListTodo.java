package com.example.todoapp.usecase;

import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.domain.repository.TodoRepository;
import com.example.todoapp.domain.vo.Code;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ListTodo {

    @Autowired
    private final TodoRepository todoRepository;

    public TodoEntity fetchByCode(Code code) {
        return todoRepository.fetchByCode(code);
    }
}
