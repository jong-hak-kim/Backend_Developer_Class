package chapter2.B_Switch;

import java.util.Scanner;

// switch 조건문
// 비교할 변수를 case 값과 비교하여 같은 case를 찾아
// 해당 case 구문부터 끝까지 실행
// break문으로 해당 switch를 종료
// default문으로 해당하는 case가 없을 때 실행할 구문을 작성
public class Switch {
	public static void main(String[] args) {
		// switch 사용 방법
//		switch (비교할 대상) {
//		case 비교할 값1: 
//			비교할 값1과 비교할 대상이 같을 경우 실행할 코드
//		case 비교할 값2:
//			비교할 값2와 비교할 대상이 같을 경우 실행할 코드
//			break구문으로 switch를 해당 위치에서 종료시킬 수 있음
//			break;
//		default:                                       
//			비교할 대상과 일치하든 안하든 실행할 코드
//		}
		
//		switch문을 조건에 따라서 코드 실행 범위를 지정하는 것
		
		Scanner scanner = new Scanner(System.in);
		
		int chapter = scanner.nextInt();
		
		switch (chapter) {
		case 1:
			System.out.println("기본 문법 공부");
		case 2:
			System.out.println("제어문 공부");
			break;
		case 3:
			System.out.println("객체지향 기본 공부");
		case 4:
			System.out.println("객체지향 응용 공부");
		case 5:
			System.out.println("자바 고급 공부");
		default:
			System.out.println("범위초과");
		}
		
	}
}
