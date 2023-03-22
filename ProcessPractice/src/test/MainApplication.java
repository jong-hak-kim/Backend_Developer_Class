package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
	private String email;
	private String password;
	private String name;
	private String phoneNumber;

	public User() {
	}

	public User(String email, String password, String name, String phoneNumber) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public User(SignUpDto dto) {
		this.email = dto.getEmail();
		this.password = dto.getPassword();
		this.name = dto.getName();
		this.phoneNumber = dto.getPhoneNumber();
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "이메일 : " + email + "\n비밀번호 : " + password + "\n이름 : " + name + "\n전화번호 : " + phoneNumber;
	}

}

public class MainApplication {

	private static UserController userController = new UserController();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SignUpDto signUpDto = new SignUpDto();
		System.out.print("이메일 : ");
		signUpDto.setEmail(scanner.nextLine());
		System.out.print("비밀번호 : ");
		signUpDto.setPassword(scanner.nextLine());
		System.out.print("비밀번호 확인 : ");
		signUpDto.setPasswordCheck(scanner.nextLine());
		System.out.print("이름 : ");
		signUpDto.setName(scanner.nextLine());
		System.out.print("전화번호 : ");
		signUpDto.setPhoneNumber(scanner.nextLine());

		userController.signUp(signUpDto);

	}

}

class UserController {
	private static UserService userService;

	public UserController() {
		userService = new UserService();
	}

	public void signUp(SignUpDto dto) {
		if (dto.validate()) {
			return;
		}

		User user = userService.signUp(dto);
		System.out.println(user.toString());
	}
}

class UserService {
	private static UserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public User signUp(SignUpDto dto) {
		String email = dto.getEmail();
		String password = dto.getPassword();
		String passwordCheck = dto.getPasswordCheck();
		boolean existEmail = userRepository.existsByEmail(email);
		if (existEmail) {
			return null;
		}
		if (!password.equals(passwordCheck)) {
			return null;
		}

		User user = new User(dto);
		userRepository.save(user);
		return user;

	}
}

class UserRepository {
	private static List<User> userTable = new ArrayList<>();

	public boolean existsByEmail(String email) {
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

class SignUpDto {
	private String email;
	private String password;
	private String passwordCheck;
	private String name;
	private String phoneNumber;

	public SignUpDto() {
	}

	public SignUpDto(String email, String password, String passwordCheck, String name, String phoneNumber) {
		this.email = email;
		this.password = password;
		this.passwordCheck = passwordCheck;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "SignUpDto [email=" + email + ", password=" + password + ", passwordCheck=" + passwordCheck + ", name="
				+ name + ", phoneNumber=" + phoneNumber + "]";
	}

	public boolean validate() {
		boolean result = this.email.isBlank() || this.password.isBlank() || this.passwordCheck.isBlank()
				|| this.name.isBlank() || this.phoneNumber.isBlank();
		return result;
	}

}
