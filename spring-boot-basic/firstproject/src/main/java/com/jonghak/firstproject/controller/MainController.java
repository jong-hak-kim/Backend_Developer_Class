package com.jonghak.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jonghak.firstproject.service.MainService;

@RestController
public class MainController {
    private final MainService mainService;

    @Autowired // Autowired를 붙이면 사용 가능
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/hello") // HTTP 요청을 통해서 GET메서드를 사용하고 포트 8080이고 path가 /hello인 것을 매핑한다
                          // postman으로 http://localhost:8080/hello 으로 보내면 hello 메소드에 대한 응답이 온다
    public String hello() {
        return mainService.hello();
    }

    @GetMapping("/jwt/{data}")
    public String getJwt(
            @PathVariable("data") String data) {
        return mainService.getJwt(data);
    }

    @PostMapping("/jwt")
    public String validJwt(
            @RequestBody String jwt) {
        return mainService.validJwt(jwt);
    }
}
