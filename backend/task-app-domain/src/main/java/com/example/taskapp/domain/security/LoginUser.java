package com.example.taskapp.domain.security;


import com.example.taskapp.domain.entity.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

/**
 * EntityのUserとUserDetailをマッピングさせるクラス
 */
public class LoginUser extends org.springframework.security.core.userdetails.User {

    public LoginUser(UserEntity userEntity) {
        super(userEntity.username(), userEntity.password(), true,
                true, true, true, Set.of(new SimpleGrantedAuthority("USER")));
    }
}
