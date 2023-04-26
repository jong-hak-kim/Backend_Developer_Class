package com.jonghak.board.service;

import org.springframework.http.ResponseEntity;

import com.jonghak.board.dto.request.user.PostUserRequestDto;
import com.jonghak.board.dto.response.ResponseDto;

public interface UserService {

    public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto);

}
