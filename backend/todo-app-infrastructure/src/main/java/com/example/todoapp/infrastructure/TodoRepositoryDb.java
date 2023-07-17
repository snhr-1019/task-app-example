package com.example.todoapp.infrastructure;

import com.example.todoapp.domain.entity.TodoEntity;
import com.example.todoapp.domain.repository.TodoRepository;
import com.example.todoapp.domain.vo.Code;
import com.example.todoapp.domain.vo.Status;
import com.example.todoapp.domain.vo.Title;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static gen.jooq.todoapp.Tables.TODO;
import static org.jooq.SQLDialect.MYSQL;

public class TodoRepositoryDb implements TodoRepository {
    @Override
    public List<TodoEntity> fetch() {
        return null;
    }

    public static void main(String[] args) {
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/todoapp";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, MYSQL);
            Result<Record> result = create.select().from(TODO).fetch();

            for (Record r : result) {
                System.out.println("Code: " + r.getValue(TODO.CODE));
                System.out.println("Title: " + r.getValue(TODO.TITLE));
                System.out.println("Status: " + r.getValue(TODO.STATUS));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public TodoEntity fetchByCode(Code code) {
        var entity = new TodoEntity(
                new Code("ABC123"),
                new Title("牛乳を買う"),
                Status.TODO
        );
        return entity;
    }
}
