package com.example.todoapp.domain.entity;

import com.example.todoapp.domain.vo.Code;
import com.example.todoapp.domain.vo.Status;
import com.example.todoapp.domain.vo.Title;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TodoEntity {
    Code code;
    Title title;
    Status status;
}
