package com.example.taskapp.domain.repository;

import com.example.taskapp.domain.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    public Optional<UserEntity> findByUsername(String username);
}
