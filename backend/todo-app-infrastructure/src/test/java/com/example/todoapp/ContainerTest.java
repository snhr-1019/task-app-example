package com.example.todoapp;

import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.domain.vo.Code;
import com.example.todoapp.domain.vo.Status;
import com.example.todoapp.domain.vo.Title;
import com.example.todoapp.infrastructure.TodoRepositoryDb;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ContainerTest {

    @Autowired
    private Flyway flyway;

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

    @BeforeEach
    void setUp() throws SQLException {
        flyway.migrate();
    }

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", MYSQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", MYSQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", MYSQL_CONTAINER::getPassword);
        registry.add("spring.datasource.driver-class-name", MYSQL_CONTAINER::getDriverClassName);
    }

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
