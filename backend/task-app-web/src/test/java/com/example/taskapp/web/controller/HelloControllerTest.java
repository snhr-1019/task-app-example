package com.example.taskapp.web.controller;

import com.example.taskapp.TaskappApplication;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TaskappApplication.class)
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Nested
    class HelloApi {
        @Test
        void testReturns200ResponseWithAnonymousUser() throws Exception {
            mockMvc.perform(
                            get("/hello")
                                    .with(anonymous())
                                    .accept(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(status().isOk())
            ;
        }

        @Test
        void testReturns200ResponseWithAuthenticatedUser() throws Exception {
            mockMvc.perform(
                            get("/hello")
                                    .with(user("some_user").roles("ANY_ROLE"))
                                    .accept(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(status().isOk())
            ;
        }
    }
}
