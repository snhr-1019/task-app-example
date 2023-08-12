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

import static gen.jooq.taskapp.Tables.TASK;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryDb implements TaskRepository {

    private final DSLContext dsl;

    @Override
    public List<TaskEntity> fetch() {
        Result<Record> result = dsl.select().from(TASK).fetch();
        return result.stream().map(this::fromRecord).toList();
    }

    @Override
    public Optional<TaskEntity> fetchByCode(Code code) {
        Record record = dsl.select().from(TASK).where(TASK.CODE.eq(code.value())).fetchOne();

        if (record == null) {
            return Optional.empty();
        } else {
            return Optional.of(fromRecord(record));
        }
    }

    @Override
    public void save(TaskEntity entity) {
        dsl.insertInto(TASK)
                .set(TASK.UUID, entity.uuid().toString())
                .set(TASK.APP_USER_UUID, entity.appUserUuid().toString())
                .set(TASK.CODE, entity.code().value())
                .set(TASK.TITLE, entity.title().value())
                .set(TASK.STATUS, entity.status().name())
                .execute();
    }

    @Override
    public void deleteByCode(Code code) {
        dsl.deleteFrom(TASK).where(TASK.CODE.eq(code.value())).execute();
    }

    private TaskEntity fromRecord(Record record) {
        return new TaskEntity(
                UUID.fromString(record.get(TASK.UUID)),
                UUID.fromString(record.get(TASK.APP_USER_UUID)),
                new Code(record.get(TASK.CODE)),
                new Title(record.get(TASK.TITLE)),
                Status.valueOf(record.get(TASK.STATUS))
        );
    }
}
