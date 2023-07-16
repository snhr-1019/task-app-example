package com.example.todoapp.domain.repository;

import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.domain.vo.Code;

import java.util.List;

public interface TodoRepository {

    List<TodoEntity> fetch();

    TodoEntity fetchByCode(Code code);
}
