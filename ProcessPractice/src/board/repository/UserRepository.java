package board.repository;

import java.util.ArrayList;
import java.util.List;

import board.entity.User;

public class UserRepository {
	private static List<User> userTable = new ArrayList<>();

	public User findByEmail(String email) {
		User result = null;
		for (User user : userTable) {
			if (user.getEmail().equals(email)) {
				result = user;
				break;
			}
		}
		return result;
	}

	public boolean existsByEmail(String email) { // 존재하는 이메일인지 검증
		boolean result = false;
		for (User user : userTable) {
			if (user.getEmail().equals(email)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public User save(User user) {
		userTable.add(user);
		return user;
	}
}
