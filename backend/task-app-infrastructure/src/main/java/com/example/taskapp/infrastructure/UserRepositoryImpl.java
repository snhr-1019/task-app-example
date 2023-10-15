package com.example.taskapp.infrastructure;

import com.example.taskapp.domain.entity.UserEntity;
import com.example.taskapp.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static gen.jooq.taskapp.Tables.USERS;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final DSLContext dsl;

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        Record record = dsl.select()
                .from(USERS)
                .where(USERS.USERNAME.eq(username))
                .fetchOne();

        if (record == null) {
            return Optional.empty();
        } else {
            return Optional.of(fromRecord(record));
        }
    }

    private UserEntity fromRecord(Record record) {
        return new UserEntity(
                record.get(USERS.ID),
                record.get(USERS.USERNAME),
                record.get(USERS.ROLES),
                record.get(USERS.PASSWORD)
        );
    }
}
