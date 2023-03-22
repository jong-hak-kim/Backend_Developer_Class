package user;

import java.util.Scanner; // 스캐너 사용
import user.controller.UserController; // UserController에 있는 signUp 메소드에 입력한 SignUpRequestDto의 값을 넣어주기 위하여 import
import user.dto.request.user.SignUpRequestDto; //입력값을 Dto에 저장하기 위해 import

public class UserApplication {
	private static UserController userController = new UserController();

	public static void main(String[] args) {
		SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 : ");
		signUpRequestDto.setName(scanner.nextLine());
		System.out.print("성별 : ");
		signUpRequestDto.setGender(scanner.nextLine());
		System.out.print("주소 : ");
		signUpRequestDto.setAddress(scanner.nextLine());
		System.out.print("전화번호 : ");
		signUpRequestDto.setPhoneNumber(scanner.nextLine());
		System.out.print("마케팅 수신 여부 (Y / N) : ");
		signUpRequestDto.setMarketingCheck(scanner.nextLine());
		System.out.print("개인정보 수집 동의 여부 (Y / N) :");
		signUpRequestDto.setCollectPersonalInfoCheck(scanner.nextLine());

		userController.signUp(signUpRequestDto);

	}
}
