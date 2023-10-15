package com.example.taskapp.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader(CommonConstants.AUTHORIZED_HEADER);
        if (!StringUtils.hasText(header) || !header.startsWith(CommonConstants.TOKEN_PREFIX)) {
            log.info("request {} was called by token {}", request.getRequestURI(), header);
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.replace(CommonConstants.TOKEN_PREFIX, "");
        try {
            // tokenを復号し中身を取得。不正があるとJwtExceptionが発生する。
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(CommonConstants.SECRET_KEY.getBytes()))
                    .build()
                    .parseClaimsJws(token);

            // 復号tokenから認証情報を作成する。
            Authentication authentication = getAuthentication(claimsJws);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // ユーザidを追加
            if (claimsJws.getBody().getSubject() != null) {
                request.setAttribute(CommonConstants.USER_ID, claimsJws.getBody().getSubject());
            }
            filterChain.doFilter(request, response);
        } catch (JwtException je) {
            log.error(je.getMessage());
            throw new IllegalStateException(String.format("Token %s cannot be trusted ", token));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private Authentication getAuthentication(Jws<Claims> claimsJws) {
        // user_id
        String userId = claimsJws.getBody().getSubject();

        // GrantedAuthorities
        @SuppressWarnings("unchecked")
        List<Map<String, String>> authorities = (List<Map<String, String>>) claimsJws.getBody()
                .get(CommonConstants.AUTHORITIES);

        Set<GrantedAuthority> grantedAuthorities = authorities.stream()
                .map(k -> new SimpleGrantedAuthority(k.get("authority")))
                .collect(Collectors.toSet());

        return new UsernamePasswordAuthenticationToken(userId, null, grantedAuthorities);
    }
}