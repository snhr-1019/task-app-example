package com.example.todoapp;

import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.domain.vo.Code;
import com.example.todoapp.domain.vo.Status;
import com.example.todoapp.domain.vo.Title;
import com.example.todoapp.infrastructure.TodoRepositoryDb;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static gen.jooq.todoapp.Tables.TODO;
import static org.assertj.core.api.Assertions.*;

public class TodoRepositoryDbTest extends RepositoryTestSupport {

    @Autowired
    private TodoRepositoryDb sut;

    @Autowired
    DSLContext dsl;

    @Nested
    class TestFetch {
        @Test
        public void testFetch() {
            // given

            // when
            List<TodoEntity> ret = sut.fetch();

            // then
            var t1 = new TodoEntity(
                    UUID.fromString("9DA58AE2-96C4-44D0-9FC6-FBBB757C0F76"),
                    UUID.fromString("74B2DDEB-5513-4820-82F5-F40BB41251E2"),
                    new Code("ABC123"),
                    new Title("牛乳を買う"),
                    Status.TODO
            );

            var t2 = new TodoEntity(
                    UUID.fromString("B92C0397-70D4-4F19-A98B-73B14C498EDF"),
                    UUID.fromString("74B2DDEB-5513-4820-82F5-F40BB41251E2"),
                    new Code("789EFG"),
                    new Title("掃除をする"),
                    Status.DOING
            );

            assertThat(ret.size()).isEqualTo(2);

            assertThat(ret.get(0)).isEqualTo(t1);
            assertThat(ret.get(1)).isEqualTo(t2);
        }
    }

    @Nested
    class TestFetchByCode {
        @ParameterizedTest
        @CsvSource({
                "9DA58AE2-96C4-44D0-9FC6-FBBB757C0F76, 74B2DDEB-5513-4820-82F5-F40BB41251E2, ABC123, 牛乳を買う, TODO",
                "B92C0397-70D4-4F19-A98B-73B14C498EDF, 74B2DDEB-5513-4820-82F5-F40BB41251E2, 789EFG, 掃除をする, DOING"
        })
        public void testFetchByCode(String todoUuidStr, String appUserUuidStr, String codeStr, String titleStr, String statusStr) {
            // given
            var code = new Code(codeStr);

            // when
            Optional<TodoEntity> ret = sut.fetchByCode(code);

            // then
            var expected = new TodoEntity(
                    UUID.fromString(todoUuidStr),
                    UUID.fromString(appUserUuidStr),
                    new Code(codeStr),
                    new Title(titleStr),
                    Status.valueOf(statusStr)
            );

            ret.ifPresentOrElse(
                    todoEntity -> assertThat(todoEntity).isEqualTo(expected),
                    () -> fail("Not found")
            );
        }

        @Test
        public void testFetchByCodeWhenNoDataFound() {
            // given
            var code = new Code("NO_DATA");

            // when
            Optional<TodoEntity> ret = sut.fetchByCode(code);

            // then
            ret.ifPresentOrElse(
                    todoEntity -> fail("Found"),
                    () -> assertThat(true).isTrue()
            );
        }
    }

    @Nested
    class SaveTest {
        @Test
        @Transactional // test data will be rolled back
        public void testSave() {
            // given
            String todoUuidStr = "2A080A9B-BA02-4407-B149-90E3531C9AA8";
            String appUserUuidStr = "74B2DDEB-5513-4820-82F5-F40BB41251E2";
            String codeStr = "NEW_CODE";
            String titleStr = "new task";
            String statusStr = "DOING";

            var entity = new TodoEntity(
                    UUID.fromString(todoUuidStr),
                    UUID.fromString(appUserUuidStr),
                    new Code(codeStr),
                    new Title(titleStr),
                    Status.valueOf(statusStr)
            );

            // when
            sut.save(entity);

            // then
            Record record = dsl.select().from(TODO).where(TODO.CODE.eq(codeStr)).fetchOne();
            assert record != null;
            assertThat(record.get(TODO.CODE)).isEqualTo(codeStr);
            assertThat(record.get(TODO.TITLE)).isEqualTo(titleStr);
            assertThat(record.get(TODO.STATUS)).isEqualTo(statusStr);
        }
    }
}
