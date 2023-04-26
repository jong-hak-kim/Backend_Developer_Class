package com.jonghak.board.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonghak.board.dto.request.user.PostUserRequestDto;
import com.jonghak.board.dto.response.ResponseDto;
import com.jonghak.board.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;
    
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> postUser(
            @Valid @RequestBody PostUserRequestDto requestBody) {
                ResponseEntity<ResponseDto> response = userService.postUser(requestBody);
        return response;
    }
}
