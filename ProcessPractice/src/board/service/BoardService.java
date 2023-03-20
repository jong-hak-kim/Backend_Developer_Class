package board.service;

import java.util.List;

import board.common.constant.ResponseMessage;
import board.dto.request.board.PostBoardDto;
import board.dto.response.ResponseDto;
import board.dto.response.board.GetBoardListResponseDto;
import board.dto.response.board.GetBoardResponseDto;
import board.dto.response.board.PostBoardResponseDto;
import board.entity.Board;
import board.entity.User;
import board.repository.BoardRepository;
import board.repository.UserRepository;

public class BoardService {
	private BoardRepository boardRepository;
	private UserRepository userRepository;

	public BoardService() {
		boardRepository = new BoardRepository();
		userRepository = new UserRepository();
	}

	public ResponseDto<PostBoardResponseDto> postBoard(PostBoardDto dto) {
		PostBoardResponseDto data = null;
		String email = dto.getWriterEmail();
		User user = userRepository.findByEmail(email);
		if (user == null) {
			return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_USER, null);
		}
		Board board = new Board(dto, user);
		boardRepository.save(board);

		data = new PostBoardResponseDto(board);
		return new ResponseDto<>(true, ResponseMessage.SUCCESS, data);
	}

	public ResponseDto<List<GetBoardListResponseDto>> getBoardList() {

		List<GetBoardListResponseDto> data = null;

		List<Board> boardList = boardRepository.findBy();

		data = GetBoardListResponseDto.copyList(boardList);

		return new ResponseDto<List<GetBoardListResponseDto>>(true, ResponseMessage.SUCCESS, data);
	}

	public ResponseDto<GetBoardResponseDto> getBoard(int boardNumber) {

		GetBoardResponseDto data = null;

		Board board = boardRepository.findByBoardNumber(boardNumber);
		if (board == null) {
			return new ResponseDto<>(false, ResponseMessage.NOT_EXIST_BOARD, null);
		}

		data = new GetBoardResponseDto(board);
		return new ResponseDto<>(true, ResponseMessage.SUCCESS, data);

	}
}
