package com.jonghak.board.service;

import org.springframework.http.ResponseEntity;

import com.jonghak.board.dto.request.auth.SignInRequestDto;
import com.jonghak.board.dto.request.auth.SignUpRequestDto;
import com.jonghak.board.dto.response.ResponseDto;
import com.jonghak.board.dto.response.auth.SignInResponseDto;

public interface AuthService {
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);

    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
