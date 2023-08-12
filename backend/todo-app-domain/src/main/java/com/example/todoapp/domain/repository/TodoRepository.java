package com.example.taskapp.domain.repository;

import com.example.taskapp.domain.entity.taskEntity;
import com.example.taskapp.domain.vo.Code;
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
