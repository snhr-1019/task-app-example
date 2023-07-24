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
import java.util.Optional;

import static gen.jooq.todoapp.Tables.TODO;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryDb implements TodoRepository {

    private final DSLContext dsl;

    @Override
    public List<TodoEntity> fetch() {
        Result<Record> result = dsl.select().from(TODO).fetch();
        return result.stream().map(this::fromRecord).toList();
    }

    @Override
    public Optional<TodoEntity> fetchByCode(Code code) {
        Record record = dsl.select().from(TODO).where(TODO.CODE.eq(code.value())).fetchOne();

        if (record == null) {
            return Optional.empty();
        } else {
            return Optional.of(fromRecord(record));
        }
    }

    private TodoEntity fromRecord(Record record) {
        return new TodoEntity(
                new Code(record.get(TODO.CODE)),
                new Title(record.get(TODO.TITLE)),
                Status.valueOf(record.get(TODO.STATUS))
        );
    }
}
