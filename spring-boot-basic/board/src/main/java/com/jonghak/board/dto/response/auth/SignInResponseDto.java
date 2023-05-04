package com.jonghak.board.dto.response.auth;

import com.jonghak.board.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponseDto extends ResponseDto{
    private String token;
    private int expirationDate;

    public SignInResponseDto(String token) {
        super("SU", "Success");
        this.token = token;
        this.expirationDate = 3600;
    }
}
