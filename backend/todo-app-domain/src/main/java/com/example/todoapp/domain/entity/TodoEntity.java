package com.example.todoapp.domain.entity;

import com.example.todoapp.domain.vo.Code;
import com.example.todoapp.domain.vo.Status;
import com.example.todoapp.domain.vo.Title;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class TodoEntity {
    private final Code code;
    private final Title title;
    private final Status status;
}
