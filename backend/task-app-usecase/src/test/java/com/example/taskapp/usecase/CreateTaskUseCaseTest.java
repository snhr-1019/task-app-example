package com.example.taskapp.usecase;

import com.example.taskapp.domain.entity.TaskEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateTaskUseCaseTest extends UseCaseTestSupport {

    @Autowired
    CreateTaskUseCase sut;

    @Test
    void testCreateTask() {
        // given
        int userId = 1;
        String title = "test";

        // when
        TaskEntity taskEntity = sut.createTask(userId, title);

        // then
        assertThat(taskEntity, notNullValue());
        assertThat(taskEntity.getTitle(), is(title));
        assertThat(taskEntity.isCompleted(), is(false));
    }
}
