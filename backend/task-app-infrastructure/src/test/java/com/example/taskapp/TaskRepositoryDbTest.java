package com.example.taskapp;

import com.example.taskapp.domain.entity.TaskEntity;
import com.example.taskapp.domain.vo.Id;
import com.example.taskapp.domain.vo.Title;
import com.example.taskapp.infrastructure.TaskRepositoryDb;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TaskRepositoryDbTest extends RepositoryTestSupport {

    @Autowired
    private TaskRepositoryDb sut;

    @Autowired
    DSLContext dsl;

    @Nested
    class TestFetch {
        @Test
        public void testFetch() {
            // given

            // when
            List<TaskEntity> ret = sut.fetch();

            // then
            var t1 = new TaskEntity(
                    new Id(1),
                    new Title("牛乳を買う"),
                    false
            );

            var t2 = new TaskEntity(
                    new Id(2),
                    new Title("掃除をする"),
                    true
            );

            assertThat(ret.size()).isEqualTo(2);

            assertThat(ret.get(0)).isEqualTo(t1);
            assertThat(ret.get(1)).isEqualTo(t2);
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
//    @Nested
//    class SaveTest {
//        @Test
//        @Transactional // test data will be rolled back
//        public void testSave() {
//            // given
//            String taskUuidStr = "2A080A9B-BA02-4407-B149-90E3531C9AA8";
//            String appUserUuidStr = "74B2DDEB-5513-4820-82F5-F40BB41251E2";
//            String codeStr = "NEW_CODE";
//            String titleStr = "new task";
//            String statusStr = "DOING";
//
//            var entity = new TaskEntity(
//                    UUID.fromString(taskUuidStr),
//                    UUID.fromString(appUserUuidStr),
//                    new Code(codeStr),
//                    new Title(titleStr),
//                    Status.valueOf(statusStr)
//            );
//
//            // when
//            sut.save(entity);
//
//            // then
//            Record record = dsl.select().from(TASKS).where(TASKS.CODE.eq(codeStr)).fetchOne();
//            assert record != null;
//            assertThat(record.get(TASKS.CODE)).isEqualTo(codeStr);
//            assertThat(record.get(TASKS.TITLE)).isEqualTo(titleStr);
//            assertThat(record.get(TASKS.STATUS)).isEqualTo(statusStr);
//        }
//    }
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
