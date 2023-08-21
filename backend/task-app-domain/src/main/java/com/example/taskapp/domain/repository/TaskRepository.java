package com.example.taskapp.domain.repository;

import com.example.taskapp.domain.entity.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository {

    public List<TaskEntity> fetch();
}