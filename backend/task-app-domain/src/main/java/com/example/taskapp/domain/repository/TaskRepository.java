package com.example.taskapp.domain.repository;

import com.example.taskapp.domain.entity.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository {

    List<TaskEntity> fetch(int userId);

    Optional<TaskEntity> fetchByTaskId(int taskId);

    /**
     * @param taskEntity
     * @return 登録後の完全なTaskEntityを返す
     */
    TaskEntity create(TaskEntity taskEntity);
}
