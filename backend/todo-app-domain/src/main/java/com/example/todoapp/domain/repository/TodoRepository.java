package com.example.todoapp.domain.repository;

import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.domain.vo.Code;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository {

    public List<TodoEntity> fetch();

    public Optional<TodoEntity> fetchByCode(Code code);

    public void save(TodoEntity entity);

    public void deleteByCode(Code code);
}
