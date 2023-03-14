package chapter1.A_Variable;

// 한 줄 주석
/* 부분 주적 */
/*
 * 여러 줄 주석
 */

// 주석 단축키 Ctrl + /

// 코드를 작성하고 나면 반드시!!! 저장 Ctrl + s

// 1. 변수 
// 모든 프로그래밍 언어는 데이터를 보관할 수 있는 변수가 존재
// 데이터를 담을 수 있는 열려있는 상자

// 변수는 반드시 선언 후 초기화 해야 사용 가능
// 선언 : 사용할 변수를 만드는 행위
// 초기화 : 변수에 초기 데이터를 저장하는 행위.

public class Variable {
	
	// main 메서드 : 실행 시 실행되는 메서드
	// {  } : 코드 블럭 - 여러 줄의 코드를 하나로 묶어주는 역할
	public static void main(String[] args) {
		// 변수 선언 방법
		// 데이터타입 변수명;
		int numberVariable;
		
		// 변수 초기화 방법
		// 변수명 = 데이터;
		numberVariable = 10;
		System.out.println(numberVariable);
		
		// 선언과 동시에 초기화
		// 데이터타입 변수명 = 데이터;
		char characterVariable = 'a';
		
		// 변수 명명 규칙
		// 1. 첫 자리가 숫자가 올 수 없음
		// 2. 연산자로 쓰지 않는 특수문자만 사용 가능 ($, _)
		// 3. 같은 코드 블럭 내에 이미 선언한 변수명은 사용 불가능
		// 4. java의 변수는 lowerCamelCase 명명 규칙을 사용.
		
		// lowerCamelCase
		// 첫 문자는 소문자로 시작하고 띄어쓰기는 제거하고
		// 다음에 오는 문자를 대문자로 작성
		int number;
		
		
	}

}
