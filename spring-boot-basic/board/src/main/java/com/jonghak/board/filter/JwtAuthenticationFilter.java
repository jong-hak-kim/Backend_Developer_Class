package com.jonghak.board.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jonghak.board.provider.JwtProvider;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtProvider jwtProvider;

    @Autowired
    public JwtAuthenticationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {

            String jwt = parseToken(request); // @ parseToken 메서드 결과값 jwt 변수에 지정
            boolean hasJwt = jwt != null;
            if (!hasJwt) {
                filterChain.doFilter(request, response);
                return;
            }

            String email = jwtProvider.validate(jwt); // @ subject에 있는 이메일 가져오기

            AbstractAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, null,
                    AuthorityUtils.NO_AUTHORITIES);

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticationToken);
            SecurityContextHolder.setContext(securityContext);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        filterChain.doFilter(request, response);
    }

    private String parseToken(HttpServletRequest request) { // @ 토큰 파싱
        String token = request.getHeader("Authorization"); // @ Authorization 헤더에 있는 것 가져오기

        boolean hasToken = token != null && !token.equalsIgnoreCase("null"); // @ 토큰을 가지고 있는지 검사

        if (!hasToken)
            return null; // @ 토큰이 없으면 null 반환

        boolean isBearer = token.startsWith("Bearer "); // @ 토큰이 Bearer로 시작하는가?
        if (!isBearer)
            return null;

        String jwt = token.substring(7); // @ 시작하면 7번째 값부터 jwt 변수에 입력
        return jwt;
    }

}
