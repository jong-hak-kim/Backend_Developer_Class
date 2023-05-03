package com.jonghak.firstproject.service;

public interface MainService {
    public String hello();

    public String getJwt(String data);
    
    public String validJwt(String data);
}
