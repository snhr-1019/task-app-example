package com.example.todoapp.infrastructure;

import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.domain.repository.TodoRepository;
import com.example.todoapp.domain.vo.Code;
import com.example.todoapp.domain.vo.Status;
import com.example.todoapp.domain.vo.Title;

import java.util.List;

public class TodoRepositoryDb implements TodoRepository {
    @Override
    public List<TodoEntity> fetch() {
        return null;
    }

    @Override
    public TodoEntity fetchByCode(Code code) {
        var entity = new TodoEntity(
                new Code("ABC123"),
                new Title("牛乳を買う"),
                Status.TODO
        );
        return entity;
    }
}
