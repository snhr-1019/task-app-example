package com.example.taskapp.web.security;

import com.example.taskapp.domain.security.LoginUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import gen.openapi.taskapp.model.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.Date;

@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        // デフォルトのpathを変更
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(CommonConstants.LOGIN_URL, "POST"));

        // デフォルトのパラメーターを変更
        setUsernameParameter(CommonConstants.USERNAME);
        setPasswordParameter(CommonConstants.PASSWORD);
    }

    /**
     * ログイン認証処理
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginRequest loginRequest = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(), // principal
                    loginRequest.getPassword() // credential
            );

            return authenticationManager.authenticate(authentication);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * ログイン成功後の処理
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(((LoginUser) authResult.getPrincipal()).getUsername()) // id
                .claim(CommonConstants.AUTHORITIES, authResult.getAuthorities()) // 権限
                .setIssuedAt(new Date()) // 発行日
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) // 有効期限
                .signWith(Keys.hmacShaKeyFor(CommonConstants.SECRET_KEY.getBytes())) // 暗号化key
                .compact();

        response.addHeader(CommonConstants.AUTHORIZED_HEADER, CommonConstants.TOKEN_PREFIX + token);
    }
}
