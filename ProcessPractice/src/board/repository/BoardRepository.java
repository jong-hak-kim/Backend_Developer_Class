package board.repository;

import java.util.ArrayList;
import java.util.List;

import board.entity.Board;

public class BoardRepository {

	public static int index = 0;

	private static List<Board> boardTable = new ArrayList<>();

	public Board save(Board board) {
		boolean isExist = false;
		for (int index = 0; index < boardTable.size(); index++) { // 존재한다면 게시물을 바꿔끼우는 작업
			Board boardItem = boardTable.get(index);
			if (boardItem.getBoardNumber() == board.getBoardNumber()) {
				boardTable.set(index, board);
				isExist = true;
				break;
			}
		}

		if (!isExist) { // 존재하지 않는다면 보드 리스트에 추가
			boardTable.add(board);
		}
		return board;
	}

	public Board findByBoardNumber(int boardNumber) {
		Board result = null;
		for (Board board : boardTable) {
			if (board.getBoardNumber() == boardNumber) {
				result = board;
				break;
			}
		}
		return result;
	}

	public List<Board> findBy() {
		return boardTable;
	}

	public void deleteByBoardNumber(int boardNumber) {
		for (int index = 0; index < boardTable.size(); index++) {
			Board board = boardTable.get(index);
			if (board.getBoardNumber() == boardNumber) {
				boardTable.remove(board);
				break;
			}
		}
	}

}
