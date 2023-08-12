package com.example.taskapp.domain.entity;

import com.example.taskapp.domain.vo.Code;
import com.example.taskapp.domain.vo.Status;
import com.example.taskapp.domain.vo.Title;

import java.util.UUID;

public record TaskEntity(UUID uuid, UUID appUserUuid, Code code, Title title, Status status) {
}
