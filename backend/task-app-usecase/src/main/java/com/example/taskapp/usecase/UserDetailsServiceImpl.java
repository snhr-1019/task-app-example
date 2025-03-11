package com.example.taskapp.usecase;

import com.example.taskapp.domain.repository.UserRepository;
import com.example.taskapp.domain.security.LoginUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Spring SecurityのUserDetailsServiceを実装
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("user {} was accessed", username);
        return userRepository.findByUsername(username)
                .map(LoginUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User [" + username + "] was not found"));
    }
}
