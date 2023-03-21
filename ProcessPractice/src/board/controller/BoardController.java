package board.controller;

import java.util.List;

import board.common.constant.HttpStatus;
import board.dto.request.board.PatchBoardDto;
import board.dto.request.board.PostBoardDto;
import board.dto.response.ResponseDto;
import board.dto.response.board.DeleteBoardResponseDto;
import board.dto.response.board.GetBoardListResponseDto;
import board.dto.response.board.GetBoardResponseDto;
import board.dto.response.board.PatchBoardResponseDto;
import board.dto.response.board.PostBoardResponseDto;
import board.service.BoardService;

public class BoardController {
	private BoardService boardService;

	public BoardController() {
		boardService = new BoardService();
	}

	public void postBoard(PostBoardDto dto) {
		if (dto.auth()) {
			System.out.println(HttpStatus.UNAUTHORIZED);
			return;
		}
		if (dto.vaild()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		ResponseDto<PostBoardResponseDto> response = boardService.postBoard(dto);
		System.out.println(response.toString());
	}

	public void getBoardList() {
		ResponseDto<List<GetBoardListResponseDto>> response = boardService.getBoardList(); // 리스트 형태로 사용자에게 보여줄 것이기 때문에
		System.out.println(response.toString()); // 제너릭 안의 제너릭으로 List 형태로
													// 반환하도록 함
	}

	public void getBoard(int boardNumber) {

		if (boardNumber <= 0) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		ResponseDto<GetBoardResponseDto> response = boardService.getBoard(boardNumber);
		System.out.println(response.toString());

	}

	public void patchBoard(PatchBoardDto dto) {
		if (dto.auth()) {
			System.out.println(HttpStatus.UNAUTHORIZED);
			return;
		}
		if (dto.valid()) {
			System.out.println(HttpStatus.BAD_REQUEST);
		}

		ResponseDto<PatchBoardResponseDto> response = boardService.patchBoard(dto);
		System.out.println(response.toString());
	}

	public void deleteBoard(int boardNumber, String email) {
		boolean auth = email.isBlank();
		if (auth) {
			System.out.println(HttpStatus.UNAUTHORIZED);
			return;
		}
		boolean valid = boardNumber <= 0;
		if (valid) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}

		ResponseDto<List<DeleteBoardResponseDto>> response = boardService.deleteBoard(boardNumber, email);
		System.out.println(response.toString());

	}
}
