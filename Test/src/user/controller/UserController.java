package user.controller;

import user.dto.request.user.SignUpRequestDto; // 입력한 값을 이용하여 모두 입력하였는지 검증과 UserService에 값을 전달하기 위해 import
import user.entity.User; // UserService에서 signUp() 메소드를 이용하여 리턴한 값이 User 타입이기 때문에 import
import user.service.UserService; // UserService에 있는 signUp() 메소드를 이용하기 위하여 import

public class UserController {
	private UserService userService;

	public UserController() {
		userService = new UserService();
	}
	
	public void signUp(SignUpRequestDto dto) {
		if (dto.validate()) {
			System.out.println("모두 입력해주세요.");
			return;
		}
		User user = userService.signUp(dto);
		System.out.println(user.toString());
	}
}
