package com.jonghak.board.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {

    @Value("${jwt.secret-key}")
    private String SECRET_KEY;

    public String create(String email) {

        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        // String id = "qwer";
        // int role = 1;

        // String jwt =
        // Jwts.builder()
        // .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        // .claim("id", id)
        // .claim("role", role)
        // .compact();

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(expiredDate)
                // .claim("id", id)
                // .claim("role", role)
                .compact();

        return jwt;
    }

    public String validate(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwt)
                .getBody();
        // String id = (String) claims.get("id");
        // int role = (Integer) claims.get("role");
        // System.out.println(id + " " + role);
        return claims.getSubject();
    }

}
