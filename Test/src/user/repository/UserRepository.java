package user.repository;

import java.util.ArrayList; //User의 각각의 값들을 넣을 리스트의 크기를 알 수 없기 때문에 ArrayList를 이용하여 값이 들어가면 리스트의 크기가 늘어나도록 하기 위하여 import
import java.util.List; //ArrayList를 사용하기 위하여 import
import user.entity.User; // 입력받은 User 타입들인 값들을 받아서 userTable에 넣기 위하여 import

public class UserRepository {
	private static List<User> userTable = new ArrayList<>();

	public User save(User user) {
		userTable.add(user);
		return user;

	}
}
