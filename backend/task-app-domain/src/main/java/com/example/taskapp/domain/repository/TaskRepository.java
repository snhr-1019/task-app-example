package com.example.taskapp.domain.repository;

import com.example.taskapp.domain.entity.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository {

    List<TaskEntity> fetch(int userId);

    void create(TaskEntity taskEntity);
}