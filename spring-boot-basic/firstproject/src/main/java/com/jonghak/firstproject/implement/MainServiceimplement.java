package com.jonghak.firstproject.implement;

import org.springframework.stereotype.Component;

import com.jonghak.firstproject.provider.JwtTokenProvider;
import com.jonghak.firstproject.service.MainService;

@Component
public class MainServiceimplement implements MainService {
    private JwtTokenProvider jwtTokenProvider;

    public MainServiceimplement(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String hello() {
        return "Hello";
    }

    @Override
    public String getJwt(String data) {
        String jwt = jwtTokenProvider.create(data);
        return jwt;
    }

    @Override
    public String validJwt(String jwt) {
        String subject = jwtTokenProvider.validate(jwt);
        return subject;
    }

}
