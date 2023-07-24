package com.example.todoapp;

import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.domain.vo.Code;
import com.example.todoapp.domain.vo.Status;
import com.example.todoapp.domain.vo.Title;
import com.example.todoapp.infrastructure.TodoRepositoryDb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
