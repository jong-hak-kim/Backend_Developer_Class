package com.jonghak.board.dto.request.board2;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.jonghak.board.dto.request.board.PatchBoardRequestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchBoardRequestDto2 {
    @NotNull
    private Integer boardNumber; // @ NotNull과 함께 사용하여 빈값을 받아오기 위하여 Integer 타입 사용
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageUrl;

    public PatchBoardRequestDto2(PatchBoardRequestDto dto) {
        this.boardNumber = dto.getBoardNumber();
        this.boardTitle = dto.getBoardTitle();
        this.boardContent = dto.getBoardContent();
        this.boardImageUrl = dto.getBoardImageUrl();
    }
}
