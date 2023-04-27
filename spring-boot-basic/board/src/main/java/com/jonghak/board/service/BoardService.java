package com.jonghak.board.service;

import org.springframework.http.ResponseEntity;

import com.jonghak.board.dto.request.board.PatchBoardRequestDto;
import com.jonghak.board.dto.request.board.PostBoardRequestDto;
import com.jonghak.board.dto.response.ResponseDto;
import com.jonghak.board.dto.response.board.GetBoardListResponseDto;
import com.jonghak.board.dto.response.board.GetBoardResponseDto;

public interface BoardService {
    public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto);

    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);

    public ResponseEntity<? super GetBoardListResponseDto> getBoardlist();

    public ResponseEntity<? super GetBoardListResponseDto> getBoardTop3();

    public ResponseEntity<ResponseDto> patchBoard(PatchBoardRequestDto dto);

    public ResponseEntity<ResponseDto> deleteBoard(String userEmail, Integer boardNumber);
}
