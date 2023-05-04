package com.jonghak.board.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jonghak.board.common.util.CustomResponse;
import com.jonghak.board.dto.response.ResponseDto;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> handlerHttpMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        return CustomResponse.vaildationFailed();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        return CustomResponse.vaildationFailed();

    }
}
