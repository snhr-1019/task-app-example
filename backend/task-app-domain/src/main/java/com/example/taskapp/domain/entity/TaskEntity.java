package com.example.taskapp.domain.entity;

import com.example.taskapp.domain.vo.Id;
import com.example.taskapp.domain.vo.Title;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskEntity {
    private final Id id;
    private final int userId;
    private final Title title;
    private final boolean completed;


    public static TaskEntity createNewTaskEntity(int userId, Title title) {
        return new TaskEntity(null, userId, title, false);
    }

    public static TaskEntity createTaskEntity(Id id, int userId, Title title, boolean completed) {
        return new TaskEntity(id, userId, title, completed);
    }
}
