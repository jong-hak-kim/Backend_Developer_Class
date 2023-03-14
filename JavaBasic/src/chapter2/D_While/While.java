package chapter2.D_While;

// while 반복문
// 일반적으로 반복 횟수가 지정되어 있지 않을 때 사용하는 반복문

public class While {

	public static void main(String[] args) {
		// while문
		// 조건을 검사하고 해당 조건이 true일 경우 코드 블럭을 실행하는 반복문
		// if문의 반복 형태
		// 반복 실행할 코드 블럭이 종료되면 조건을 다시 검사하고
		// true면 반복, false면 탈출
		// 사용 방법 : while (조건) { 실행할 코드 }
		int number = 0;

		while (true) {
			// continue : continue문을 만나면 코드 블럭 내에서 아래에 오는
			// 모든 코드를 무시하고 다시 조건을 검사
			// 일반적으로 continue문은 조건문과 함께 쓰임
			// ! 조건문의 코드블럭 내에 해당 변수를 변경시켜주는 코드가 존재해야 함
			if ((number % 2) == 0) {
				number++;
				continue;
			}
			System.out.println(number);
			// while문에서는 조건에 사용되는 변수가
			// 필수로 실행코드 내에서 변경이 이루어 져야 함
			number++;
			// break : 반복문의 코드블럭을 강제로 종료 시킬 때 사용
			// 일반적으로 break문은 조건문과 함께 사용됨
			if (number == 200)
				break;
		}
		
		// number = 200
		
		// do - while
		// 반복 실행할 코드를 무조건 한 번 실행한 후에 조건을 검사하는 반복문
		// 사용 방법 : do { 실행할 코드} while (조건);
		do {
			System.out.println(number);
			number++;
		} while (number < 200);
		System.out.println(number);
	}

}


// 프로그램 : Input(입력) -> Process(절차) -> Output(출력)
