package com.example.todoapp.domain.entity;

import com.example.todoapp.domain.vo.Code;
import com.example.todoapp.domain.vo.Status;
import com.example.todoapp.domain.vo.Title;

public record TodoEntity(Code code, Title title, Status status) {
}
