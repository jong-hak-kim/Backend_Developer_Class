package board.service;

import board.repository.BoardRepository;

public class BoardService {
	private BoardRepository boardRepository;
	
	public BoardService() {
		boardRepository = new BoardRepository();
	}
}
