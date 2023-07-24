package com.example.todoapp.domain.entity;

import com.example.todoapp.domain.vo.Code;
import com.example.todoapp.domain.vo.Status;
import com.example.todoapp.domain.vo.Title;

import java.util.UUID;

public record TodoEntity(UUID uuid, UUID appUserUuid, Code code, Title title, Status status) {
}
