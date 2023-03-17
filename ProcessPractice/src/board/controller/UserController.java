package board.controller;

import board.common.constant.HttpStatus;
import board.dto.request.user.SignInDto;
import board.dto.request.user.SignUpDto;
import board.dto.response.ResponseDto;
import board.dto.response.user.SignInResponseDto;
import board.service.UserService;

public class UserController {

	private UserService userService;

	public UserController() {
		userService = new UserService();
	}

	public void signUp(SignUpDto dto) {

		if (dto.validate()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}

		ResponseDto<Boolean> response = userService.signUp(dto);
		System.out.println(response.toString());

	}

	public void signIn(SignInDto dto) {
		if (dto.vaildate()) {
			System.out.println(HttpStatus.BAD_REQUEST);
			return;
		}
		
		ResponseDto<SignInResponseDto> response = userService.signIn(dto);
		System.out.println(response.toString());
	}

}
