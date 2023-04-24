package com.jonghak.firstproject.service.Implement;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jonghak.firstproject.service.RestApiService;

@Service
public class RestApiServiceImplement implements RestApiService {
    public String getMethod() {
        return "Return to Service Layer";
    }
}
