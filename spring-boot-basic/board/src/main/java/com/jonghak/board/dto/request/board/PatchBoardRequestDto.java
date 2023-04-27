package com.jonghak.board.dto.request.board;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchBoardRequestDto {
    @NotBlank
    @Email
    private String userEmail;
    @NotNull
    private Integer boardNumber; // @ NotNull과 함께 사용하여 빈값을 받아오기 위하여 Integer 타입 사용
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageUrl;
}
