package chapter2.C_For;

public class For {

// for 반복문
// 규칙이 있는 작업을 반복하는 제어문
// 일반적으로 반복 횟수가 정해져 있을 때 사용하는 반복문

	public static void main(String[] args) {
		// 반복문을 사용하는 이유
		// 길이가 5인 int 타입의 배열(intArray5)을 선언 및 생성
		int[] intArray5 = new int[5];
		// intArray5의 각 인덱스에 1~5까지 값으로 초기화
		intArray5[0] = 1;
		intArray5[1] = 2;
		intArray5[2] = 3;
		intArray5[3] = 4;
		intArray5[4] = 5;

		// for 반복문
		// 특정한 변수가 증감하며 조건에 부합하는 동안 반복하는 반복문
		// 사용 방법 :
		// for (변수 선언 혹은 초기화; 조건; 증감식) { 실행할 코드 };

		// 변수 선언 혹은 초기화 : 반복문을 위해 사용할 변수를 선언 혹은 초기화
		// 조건 : 반복을 계속하기 위한 조건, true이면 반복, false면 탈출
		// 실행할 코드 : 조건이 true일 때 실행할 코드

		for (int index = 0; index <= 4; index++) {
			intArray5[index] = index + 1;
		}

		// for 문의 경우 코드 블럭에 오는 실행할 코드가 한 구문이면
		// {} 를 제거할 수 있음
		for (int index = 0; index < 5; index++)
			intArray5[index] = index + 1;

		// foreach 반복문
		// 배열의 요소 값을 직접 읽고자 할 때 배열을 반복하면서
		// 요소를 하나씩 복사해서 사용할 수 있음
		// 사용 방법 : for (배열요소의데이터타입 변수명 : 배열) { 실행할 코드 };
//		System.out.println(intArray5[0]);
//		System.out.println(intArray5[1]);
//		System.out.println(intArray5[2]);
//		System.out.println(intArray5[3]);
//		System.out.println(intArray5[4]);
		System.out.println("===== 일반 for문 =====");
		for (int index = 0; index < intArray5.length; index++) {
			System.out.println(intArray5[index]);
			intArray5[index] = 10;
		}

		for (int number : intArray5)
			System.out.println(number);

		
		System.out.println("===== foreach 문 =====");
		for (int index = 0; index < intArray5.length; index++) {
			intArray5[index] = index + 1;
		}

		for (int number : intArray5) { // 실제 데이터가 아닌 복사된 값이 변경이 됨
			System.out.println(number);
			number = 10;
		}

		for (int number : intArray5) {
			System.out.println(number);
			number = 10;
		}
	}

}
