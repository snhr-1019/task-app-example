package com.example.todoapp.domain.repository;

import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.domain.vo.Code;

public interface TodoRepository {
    TodoEntity fetchByCode(Code code);
}
