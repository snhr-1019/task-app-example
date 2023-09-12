package com.example.taskapp;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryTestConfig {

    @Bean
    public FlywayMigrationStrategy migrateStrategy() {
        return Flyway::migrate;
    }
}
