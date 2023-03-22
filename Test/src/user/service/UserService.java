package user.service;

import user.dto.request.user.SignUpRequestDto; //유저에게서 받은 입력값을 전달해주기 위하여 import
import user.entity.User; //User 클래스에 있는 getset을 이용하여 값을 넣어주거나 userRepository에 값을 전달해주기 위해 import
import user.repository.UserRepository; //UserRepository에 있는 save() 메소드를 사용하기 위하여 import

public class UserService {
	private static UserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public User signUp(SignUpRequestDto dto) {

		User user = new User(dto);
		if (dto.getMarketingCheck().equals("N")) {
			user.setMarketingCheck(false);
		}
		if (dto.getMarketingCheck().equals("Y")) {
			user.setMarketingCheck(true);
		}
		if (dto.getCollectPersonalInfoCheck().equals("N")) {
			user.setCollectPersonalInfoCheck(false);
		}
		if (dto.getCollectPersonalInfoCheck().equals("Y")) {
			user.setCollectPersonalInfoCheck(true);
		}
		
		userRepository.save(user);
		return user;

	}
}
