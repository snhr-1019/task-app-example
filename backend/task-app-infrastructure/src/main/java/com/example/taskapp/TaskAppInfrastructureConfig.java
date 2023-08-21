package com.example.taskapp;

import com.example.taskapp.domain.repository.TaskRepository;
import com.example.taskapp.infrastructure.TaskRepositoryImpl;
import org.jooq.DSLContext;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class TaskAppInfrastructureConfig {
    static {
        System.out.println("TaskAppInfrastructureConfig");
    }
    @Bean
    public TaskRepository taskRepository(DSLContext dsl) {
        return new TaskRepositoryImpl(dsl);
    }
}
