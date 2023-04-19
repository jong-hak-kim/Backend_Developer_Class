package com.jonghak.firstproject.implement;

import org.springframework.stereotype.Component;

import com.jonghak.firstproject.service.MainService;

@Component
public class MainServiceimplement implements MainService {

    @Override
    public String hello() {
        return "Hello";
    }

}
