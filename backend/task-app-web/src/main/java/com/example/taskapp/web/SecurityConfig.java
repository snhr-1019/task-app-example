package com.example.taskapp.web;

import com.example.taskapp.web.security.JwtAccessDeniedHandler;
import com.example.taskapp.web.security.JwtAuthenticationEntryPoint;
import com.example.taskapp.web.security.JwtAuthenticationFilter;
import com.example.taskapp.web.security.JwtAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        var authenticationManager = authenticationManager(http.getSharedObject(AuthenticationConfiguration.class));
        http
                .csrf(AbstractHttpConfigurer::disable) // CSRFトークンの無効化
                .sessionManagement(session -> session // RESTなのでセッションをステートレスにする
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authorize -> authorize // リクエスト認証
                        // for springdoc TODO separate to only development profile
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .requestMatchers("/hello").permitAll() // localhost:8080/api/helloへのリクエストは認証なしで許可
                        .anyRequest().authenticated() // 上記以外のリクエストは認証が必要
                )
                .addFilter(new JwtAuthenticationFilter(authenticationManager)) // request認証とtokenを発行するfilter
                .addFilterAfter(new JwtAuthorizationFilter(), JwtAuthenticationFilter.class) // tokenの承認を行うfilter
                .exceptionHandling(exceptionHandling -> exceptionHandling // エラーハンドリング
                        .accessDeniedHandler(new JwtAccessDeniedHandler()) // ログインエラー時のハンドラー設定(未ログインも)
                        .authenticationEntryPoint(new JwtAuthenticationEntryPoint()) // 権限エラー時のハンドラー設定
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
