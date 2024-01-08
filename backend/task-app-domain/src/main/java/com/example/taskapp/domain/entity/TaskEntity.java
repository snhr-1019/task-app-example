package com.example.taskapp.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskEntity {
    private final int id;
    private final int userId;
    private final String title;
    private final boolean completed;


    public static TaskEntity createNewTaskEntity(int userId, String title) {
        return new TaskEntity(0, userId, title, false);
    }

    public static TaskEntity createTaskEntity(int id, int userId, String title, boolean completed) {
        return new TaskEntity(id, userId, title, completed);
    }
}
