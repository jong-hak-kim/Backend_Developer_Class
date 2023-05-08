package com.jonghak.board.dto.request.board2;

import javax.validation.constraints.NotBlank;

import com.jonghak.board.dto.request.board.PostBoardRequestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostBoardRequestDto2 {
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageUrl;

    public PostBoardRequestDto2(PostBoardRequestDto dto) {
        this.boardTitle = dto.getBoardTitle();
        this.boardContent = dto.getBoardContent();
        this.boardImageUrl = dto.getBoardImageUrl();
    }
}
