package com.jonghak.firstproject.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jonghak.firstproject.provider.JwtTokenProvider;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {

            String jwt = parseToken(request);

            boolean hasJwt = jwt != null;
            if (!hasJwt) {
                filterChain.doFilter(request, response);
                return;
            }

            String subject = jwtTokenProvider.validate(jwt);

            //가져온 subject를 접근 주체로 만든 다음 이름, 비밀번호, 권한을 만들어준다
            AbstractAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(subject, null,
                    AuthorityUtils.NO_AUTHORITIES); // UsernamePasswordAuthenticationToken(이름, 비밀번호, 권한)

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // 빈 컨텍스트 생성
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

            // 빈 컨텍스트에 보안 컨텍스트 등록
            securityContext.setAuthentication(authenticationToken);
            SecurityContextHolder.setContext(securityContext);
        
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        filterChain.doFilter(request, response);
    }

    private String parseToken(HttpServletRequest request) {
        // * Request Header 중 "Authorization" : "Bearer eyJh..." 값을 가져오겠다
        // @ 위의 값 존재 여부 확인
        String token = request.getHeader("Authorization"); // 헤더 이름 지정
        boolean hasToken = token != null & !token.equals("null");
        if (!hasToken)
            return null;

        // @ token 변수가 Bearer로 시작되어 있으면 Bearer로 지정되어 있는 것인지 확인
        boolean isBearer = token.startsWith("Bearer ");
        if (!isBearer)
            return null;

        // @ token의 7번 인덱스부터의 값을 jwt 변수에 넣어준다
        // * Bearer eyJh...로 시작한다면 Bearer 를 제거하고 가져온 값을 jwt 변수에 넣어주겠다
        String jwt = token.substring(7);
        return jwt;
    }

}
