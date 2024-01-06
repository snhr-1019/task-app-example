package com.example.taskapp.infrastructure;

import com.example.taskapp.domain.entity.TaskEntity;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static gen.jooq.taskapp.Tables.TASKS;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TaskRepositoryImplTest extends RepositoryTestSupport {

    @Autowired
    TaskRepositoryImpl sut;

    @Autowired
    DSLContext dsl;

    @Nested
    class TestFetch {
        @Test
        public void testFetch() {
            // given
            int userId = 1;

            // when
            List<TaskEntity> ret = sut.fetch(userId);

            // then
            var t1 = TaskEntity.createTaskEntity(
                    1,
                    userId,
                    "牛乳を買う",
                    false
            );

            var t2 = TaskEntity.createTaskEntity(
                    2,
                    userId,
                    "掃除をする",
                    true
            );

            assertThat(ret.size(), is(2));
            // TODO order byの指定がないので、setとしての一致しか見れてない
            assertThat(Set.copyOf(ret), is(Set.of(t1, t2)));
        }
    }

    @Nested
    class TestSave {
        @Test
        @Transactional // test data will be rolled back
        public void testSave() {
            // given
            int userId = 1;
            String title = "new task";

            var entity = TaskEntity.createNewTaskEntity(userId, title);

            // when
            sut.create(entity);

            // then
            Record record = dsl.select().from(TASKS).where(TASKS.TITLE.eq(title)).fetchOne();
            assertThat(record, is(notNullValue()));
            assertThat(record.get(TASKS.USER_ID), is(userId));
            assertThat(record.get(TASKS.TITLE), is(title));
            assertThat(record.get(TASKS.COMPLETED), is((byte) 0)); // 初期登録時は未完了で作成される
        }
    }

//    @Nested
//    class TestFetchByCode {
//        @ParameterizedTest
//        @CsvSource({
//                "9DA58AE2-96C4-44D0-9FC6-FBBB757C0F76, 74B2DDEB-5513-4820-82F5-F40BB41251E2, ABC123, 牛乳を買う, TASKS",
//                "B92C0397-70D4-4F19-A98B-73B14C498EDF, 74B2DDEB-5513-4820-82F5-F40BB41251E2, 789EFG, 掃除をする, DOING"
//        })
//        public void testFetchByCode(String taskUuidStr, String appUserUuidStr, String codeStr, String titleStr, String statusStr) {
//            // given
//            var code = new Code(codeStr);
//
//            // when
//            Optional<TaskEntity> ret = sut.fetchByCode(code);
//
//            // then
//            var expected = new TaskEntity(
//                    UUID.fromString(taskUuidStr),
//                    UUID.fromString(appUserUuidStr),
//                    new Code(codeStr),
//                    new Title(titleStr),
//                    Status.valueOf(statusStr)
//            );
//
//            ret.ifPresentOrElse(
//                    taskEntity -> assertThat(taskEntity).isEqualTo(expected),
//                    () -> fail("Not found")
//            );
//        }
//
//        @Test
//        public void testFetchByCodeWhenNoDataFound() {
//            // given
//            var code = new Code("NO_DATA");
//
//            // when
//            Optional<TaskEntity> ret = sut.fetchByCode(code);
//
//            // then
//            ret.ifPresentOrElse(
//                    taskEntity -> fail("Found"),
//                    () -> assertThat(true).isTrue()
//            );
//        }
//    }
//
//
//    @Nested
//    class DeleteTest {
//        @Test
//        @Transactional // test data will be rolled back
//        public void testDelete() {
//            // given
//            String codeStr = "ABC123";
//
//            Record recordBefore = dsl.select().from(TASKS).where(TASKS.CODE.eq(codeStr)).fetchOne();
//            assertThat(recordBefore).isNotNull();
//
//            // when
//            sut.deleteByCode(new Code(codeStr));
//
//            // then
//            Record recordAfter = dsl.select().from(TASKS).where(TASKS.CODE.eq(codeStr)).fetchOne();
//            assertThat(recordAfter  ).isNull();
//        }
//    }
}
