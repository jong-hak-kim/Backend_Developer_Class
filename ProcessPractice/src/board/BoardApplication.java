package board;

import java.util.Scanner;

import board.common.constant.HttpStatus;
import board.controller.BoardController;
import board.controller.UserController;
import board.dto.request.board.PostBoardDto;
import board.dto.request.user.SignInDto;
import board.dto.request.user.SignUpDto;

public class BoardApplication {

	private static UserController userController = new UserController();
	private static BoardController boardController = new BoardController();

	private static final String SIGN_UP = "POST /sign-up";
	private static final String SIGN_IN = "POST /sign-in";

	private static final String POST_BOARD = "POST /board";
	private static final String GET_BOARD = "GET /board";
	private static final String GET_BOARD_LIST = "GET /board/list";
	private static final String PATCH_BOARD = "PATCH /board";
	private static final String DELETE_BOARD = "DELETE /board";

	public static void main(String[] args) {
		while (true) {

			Scanner scanner = new Scanner(System.in);
			System.out.print("URL End point : ");
			String endPoint = scanner.nextLine();

			switch (endPoint) {
			case SIGN_UP:
				SignUpDto signUpDto = new SignUpDto(); // SignUpDto를 가져와서 입력을 받는다
				System.out.print("이메일 주소 : ");
				signUpDto.setEmail(scanner.nextLine());
				System.out.print("비밀번호 : ");
				signUpDto.setPassword(scanner.nextLine());
				System.out.print("비밀번호 확인 : ");
				signUpDto.setPasswordCheck(scanner.nextLine());
				System.out.print("닉네임 : ");
				signUpDto.setNickname(scanner.nextLine());
				System.out.print("휴대전화 번호 : ");
				signUpDto.setPhoneNumber(scanner.nextLine());
				System.out.print("주소 : ");
				signUpDto.setAddress(scanner.nextLine());
				System.out.print("상세 주소 : ");
				signUpDto.setAddressDetail(scanner.nextLine());

//				System.out.println(dto.toString()); dto에 값이 잘 들어갔는지 확인

				userController.signUp(signUpDto); // 컨트롤러에 있는 signUp 메소드에 전달
				break;

			case SIGN_IN:
				SignInDto signInDto = new SignInDto();
				System.out.print("이메일 주소 : ");
				signInDto.setEmail(scanner.nextLine());
				System.out.print("비밀번호 : ");
				signInDto.setPassword(scanner.nextLine());

//				System.out.println(signInDto.toString()); dto에 값이 잘 들어갔는지 확인

				userController.signIn(signInDto); // 컨트롤러에 있는 signIn 메소드에 전달

				break;
			case POST_BOARD:
				PostBoardDto postBoardDto = new PostBoardDto();
				System.out.print("제목 : ");
				postBoardDto.setTitle(scanner.nextLine());
				System.out.print("내용 : ");
				postBoardDto.setContent(scanner.nextLine());
				System.out.print("이미지 : ");
				postBoardDto.setBoardImageUrl(scanner.nextLine());
				System.out.println("작성자 이메일 : ");
				postBoardDto.setWriterEmail(scanner.nextLine());

				boardController.postBoard(postBoardDto);
				break;

			case GET_BOARD_LIST:
				boardController.getBoardList();
				break;

			case GET_BOARD:
				int boardNumber = 0;
				try {
					System.out.print("게시물 번호 : ");
					boardNumber = scanner.nextInt();
				} catch (Exception exception) {
					exception.printStackTrace();
					continue;
				}

				boardController.getBoard(boardNumber);
			default:
				System.out.println(HttpStatus.NOT_FOUND);
			}
		}
	}
}
