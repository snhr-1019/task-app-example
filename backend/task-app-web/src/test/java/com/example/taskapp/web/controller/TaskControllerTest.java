package com.example.taskapp.web.controller;

import com.example.taskapp.TaskappApplication;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TaskappApplication.class)
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    class GetTaskApi {
        @Test
        void testReturns401ResponseWithAnonymousUser() throws Exception {
            mockMvc.perform(
                            get("/task")
                                    .with(anonymous())
                                    .accept(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(status().isUnauthorized())
            ;
        }

        @ParameterizedTest
        @CsvSource({
                "tanaka, 2",
                "yamada, 1",
        })
        void testReturns200ResponseWithAuthenticatedUser(String username, int expectedTaskNum) throws Exception {
            mockMvc.perform(
                            get("/task")
                                    .with(user(username).roles("ANY_ROLE"))
                                    .accept(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.tasks.length()").value(expectedTaskNum))
            ;
        }
    }
}
