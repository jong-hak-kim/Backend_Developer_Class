package com.jonghak.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonghak.board.dto.request.auth.SignInRequestDto;
import com.jonghak.board.dto.request.auth.SignUpRequestDto;
import com.jonghak.board.dto.response.ResponseDto;
import com.jonghak.board.dto.response.auth.SignInResponseDto;
import com.jonghak.board.service.AuthService;

@RestController
@RequestMapping("api/v2/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("sign-up")
    public ResponseEntity<ResponseDto> signUp(
            @Valid @RequestBody SignUpRequestDto requestBody) {
        ResponseEntity<ResponseDto> response = authService.signUp(requestBody);
        return response;
    }

    @PostMapping("sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn(
            @Valid @RequestBody SignInRequestDto requestBody) {
        ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }

}
