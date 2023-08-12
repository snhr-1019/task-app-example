package com.example.taskapp.infrastructure;

import com.example.taskapp.domain.entity.TaskEntity;
import com.example.taskapp.domain.repository.TaskRepository;
import com.example.taskapp.domain.vo.Id;
import com.example.taskapp.domain.vo.Title;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static gen.jooq.taskapp.Tables.TASKS;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryDb implements TaskRepository {

    private final DSLContext dsl;

    @Override
    public List<TaskEntity> fetch() {
        Result<Record> result =
                dsl.select()
                        .from(TASKS)
                        .fetch();
        return result.stream().map(this::fromRecord).toList();
    }

//    @Override
//    public Optional<TaskEntity> fetchByCode(Code code) {
//        Record record = dsl.select().from(TASKS).where(TASKS.CODE.eq(code.value())).fetchOne();
//
//        if (record == null) {
//            return Optional.empty();
//        } else {
//            return Optional.of(fromRecord(record));
//        }
//    }
//
//    @Override
//    public void save(TaskEntity entity) {
//        dsl.insertInto(TASKS)
//                .set(TASKS.UUID, entity.uuid().toString())
//                .set(TASKS.APP_USER_UUID, entity.appUserUuid().toString())
//                .set(TASKS.CODE, entity.code().value())
//                .set(TASKS.TITLE, entity.title().value())
//                .set(TASKS.STATUS, entity.status().name())
//                .execute();
//    }

    private TaskEntity fromRecord(Record record) {
        return new TaskEntity(
                new Id(record.get(TASKS.ID)),
                new Title(record.get(TASKS.TITLE)),
                record.get(TASKS.COMPLETED).equals(Byte.valueOf("1"))
        );
    }
}
