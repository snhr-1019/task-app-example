package com.example.taskapp.usecase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateTaskUseCaseTest extends UseCaseTestSupport {

    @Autowired
    CreateTaskUseCase sut;

    @Test
    void test() {
        sut.createTask();
    }
}
