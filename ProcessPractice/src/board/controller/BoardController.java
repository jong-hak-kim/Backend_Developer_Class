package board.controller;

import board.service.BoardService;

public class BoardController {
	private BoardService boardService;
	
	public BoardController() {
		boardService = new BoardService();
	}
}
