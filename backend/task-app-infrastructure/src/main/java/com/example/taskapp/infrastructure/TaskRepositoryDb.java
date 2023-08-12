package com.example.taskapp.infrastructure;

import com.example.taskapp.domain.entity.TaskEntity;
import com.example.taskapp.domain.repository.TaskRepository;
import com.example.taskapp.domain.vo.Code;
import com.example.taskapp.domain.vo.Status;
import com.example.taskapp.domain.vo.Title;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static gen.jooq.taskapp.Tables.TODO;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryDb implements TaskRepository {

    private final DSLContext dsl;

    @Override
    public List<TaskEntity> fetch() {
        Result<Record> result = dsl.select().from(TODO).fetch();
        return result.stream().map(this::fromRecord).toList();
    }

    @Override
    public Optional<TaskEntity> fetchByCode(Code code) {
        Record record = dsl.select().from(TODO).where(TODO.CODE.eq(code.value())).fetchOne();

        if (record == null) {
            return Optional.empty();
        } else {
            return Optional.of(fromRecord(record));
        }
    }

    @Override
    public void save(TaskEntity entity) {
        dsl.insertInto(TODO)
                .set(TODO.UUID, entity.uuid().toString())
                .set(TODO.APP_USER_UUID, entity.appUserUuid().toString())
                .set(TODO.CODE, entity.code().value())
                .set(TODO.TITLE, entity.title().value())
                .set(TODO.STATUS, entity.status().name())
                .execute();
    }

    @Override
    public void deleteByCode(Code code) {
        dsl.deleteFrom(TODO).where(TODO.CODE.eq(code.value())).execute();
    }

    private TaskEntity fromRecord(Record record) {
        return new TaskEntity(
                UUID.fromString(record.get(TODO.UUID)),
                UUID.fromString(record.get(TODO.APP_USER_UUID)),
                new Code(record.get(TODO.CODE)),
                new Title(record.get(TODO.TITLE)),
                Status.valueOf(record.get(TODO.STATUS))
        );
    }
}
