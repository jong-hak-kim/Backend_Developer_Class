package com.jonghak.board.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jonghak.board.dto.response.ResponseDto;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> handlerHttpMessageNotReadableException(HttpMessageNotReadableException exception)//처리하고자 하는 예외를 매개변수로 받아온다
    { 
        ResponseDto responseBody = new ResponseDto("VF", "Request Parameter Validation Failed");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody); //상태가 BAD_REQUEST일 때 body를 responseBody를 출력하겠다

}
}
