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

import static gen.jooq.taskapp.Tables.TASKS;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

    private final DSLContext dsl;

    @Override
    public List<TaskEntity> fetch(int userId) {
        Result<Record> result =
                dsl.select()
                        .from(TASKS)
                        .where(TASKS.USER_ID.eq(userId))
                        .fetch();
        return result.stream().map(this::fromRecord).toList();
    }

    @Override
    public void create(TaskEntity taskEntity) {
        dsl.insertInto(TASKS)
                .set(TASKS.USER_ID, taskEntity.getUserId())
                .set(TASKS.TITLE, taskEntity.getTitle().value())
                .set(TASKS.COMPLETED, (byte) (taskEntity.isCompleted() ? 1 : 0))
                .execute();
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
        return TaskEntity.createTaskEntity(
                new Id(record.get(TASKS.ID)),
                record.get(TASKS.USER_ID),
                new Title(record.get(TASKS.TITLE)),
                record.get(TASKS.COMPLETED).equals(Byte.valueOf("1"))
        );
    }
}
