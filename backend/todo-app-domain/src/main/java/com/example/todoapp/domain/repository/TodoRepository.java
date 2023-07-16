package com.example.todoapp.domain.repository;

import com.example.todoapp.domain.entity.TodoEntity;

public interface TodoRepository {
    TodoEntity fetchByCode(String code);
}
