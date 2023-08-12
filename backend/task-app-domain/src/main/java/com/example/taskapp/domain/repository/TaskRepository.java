package com.example.taskapp.domain.repository;

import com.example.taskapp.domain.entity.TaskEntity;
import com.example.taskapp.domain.vo.Code;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository {

    public List<TaskEntity> fetch();

    public Optional<TaskEntity> fetchByCode(Code code);

    public void save(TaskEntity entity);

    public void deleteByCode(Code code);
}
