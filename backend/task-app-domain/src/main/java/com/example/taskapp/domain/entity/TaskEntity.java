package com.example.taskapp.domain.entity;

import com.example.taskapp.domain.vo.Id;
import com.example.taskapp.domain.vo.Title;

public record TaskEntity(Id id, int userId, Title title, boolean completed) {
}
