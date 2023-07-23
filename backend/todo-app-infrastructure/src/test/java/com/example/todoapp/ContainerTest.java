package com.example.todoapp;

import com.example.todoapp.infrastructure.TodoRepositoryDb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ContainerTest {

    @Autowired
    private TodoRepositoryDb sut;

    static final DockerImageName MYSQL_IMAGE_NAME = DockerImageName
            .parse("mysql")
            .withTag("8.0.33");

    static final MySQLContainer<?> MYSQL_CONTAINER = new MySQLContainer<>(MYSQL_IMAGE_NAME)
            .withDatabaseName("todoapp")
            .withUsername("root")
            .withPassword("root");

    static {
        MYSQL_CONTAINER.start();
    }

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", MYSQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", MYSQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", MYSQL_CONTAINER::getPassword);
        registry.add("spring.datasource.driver-class-name", MYSQL_CONTAINER::getDriverClassName);
    }

    @Test
    public void testSample() {
        assertThat(MYSQL_CONTAINER.isRunning()).isTrue();
    }
}
