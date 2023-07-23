package com.example.todoapp.infrastructure;

import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.domain.repository.TodoRepository;
import com.example.todoapp.domain.vo.Code;
import com.example.todoapp.domain.vo.Status;
import com.example.todoapp.domain.vo.Title;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.util.List;

import static gen.jooq.todoapp.Tables.TODO;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryDb implements TodoRepository {

    private final DSLContext dsl;

    @Override
    public List<TodoEntity> fetch() {
        Result<Record> result = dsl.select().from(TODO).fetch();

        for (Record r : result) {
            System.out.println("Code: " + r.getValue(TODO.CODE));
            System.out.println("Title: " + r.getValue(TODO.TITLE));
            System.out.println("Status: " + r.getValue(TODO.STATUS));
        }

        var todo = new TodoEntity(
                new Code("ABC123"),
                new Title("牛乳を買う"),
                Status.TODO
        );
        return List.of(todo);
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
