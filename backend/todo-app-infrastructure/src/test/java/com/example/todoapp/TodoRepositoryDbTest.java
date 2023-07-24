package com.example.todoapp;

import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.domain.vo.Code;
import com.example.todoapp.domain.vo.Status;
import com.example.todoapp.domain.vo.Title;
import com.example.todoapp.infrastructure.TodoRepositoryDb;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class TodoRepositoryDbTest extends RepositoryTestSupport {

    @Autowired
    private TodoRepositoryDb sut;


    @Test
    public void testFetch() {
        // given

        // when
        List<TodoEntity> ret = sut.fetch();

        // then
        var t1 = new TodoEntity(
                new Code("ABC123"),
                new Title("牛乳を買う"),
                Status.TODO
        );

        var t2 = new TodoEntity(
                new Code("789EFG"),
                new Title("掃除をする"),
                Status.DOING
        );

        assertThat(ret.size()).isEqualTo(2);

        assertThat(ret.get(0)).isEqualTo(t1);
        assertThat(ret.get(1)).isEqualTo(t2);
    }

    @ParameterizedTest
    @CsvSource({
            "ABC123, 牛乳を買う, TODO",
            "789EFG, 掃除をする, DOING"
    })
    public void testFetchByCode(String codeStr, String titleStr, String statusStr) {
        // given
        var code = new Code(codeStr);

        // when
        Optional<TodoEntity> ret = sut.fetchByCode(code);

        // then
        var expected = new TodoEntity(
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
