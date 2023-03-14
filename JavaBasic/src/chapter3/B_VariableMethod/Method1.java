package chapter3.B_VariableMethod;

//import java.lang.Math;
// 메소드
// 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것
// 작업을 미리 작성해둔 것
// 메소드에 넣을 값과 반환 값만 알면 됨 (Black Box 구조)

// 메소드의 장점
// 1. 높은 재사용성 : 한번 만들어 놓은 메소드를 반복해서 사용 가능
// 2. 중복 코드 제거 : 반복적으로 나타내는 문장들을 메소드로 만들어서 사용하면 코드의 중복을 제거할 수 있고
// 3. 프로그램 구조화 : 작업 단위로 여러 개의 메소드에 담아 프로그램을 구조화할 수 있음

// 파라미터가 있는 메소드는 반드시 파라미터 범위 등과 같은 검증을 먼저 해줘야 함
class HigherMathmatics {
	
	static final double PIE = 3.14;
	
	// 클래스 변수와 마찬가지로 메소드에 static 포함하게 되면
	// 클래스 메소드로 사용할 수 있음 (클래스로 사용할 수 있음)
	
	static double getTriangleSize(double underside, double height) {
		if (underside <= 0 || height <= 0) { //입력을 받는 모든 메소드는 입력을 모두 검증해야한다.
			System.out.println("밑변과 높이는 양수이어야 합니다.");
			return 0;
		}
		double size = 0.5 * underside * height;
		return size;
	}

	static double getCircleSize(double radius) {
		if (radius <= 0) {
			System.out.println("반지름은 양수이여야 합니다.");
			return 0;
		}
		double size = PIE * radius * radius;
		return size;
	}
	
	static double getCircumference(double radius) {
		if (radius <= 0) {
			System.out.println("반지름은 양수이어야 합니다.");
			return 0;
		}
		double circumference = PIE * 2 * radius;
		return circumference;
	}
}

public class Method1 {

	// 메소드의 선언부
	// [접근제어자 기타제어자] 반환타입 메소드명([매개변수[, ...])
	public static void main(String[] args)
	// 메소드의 구현부
	// 실제 프로그램의 절차를 작성하는 부분
	// return 데이터; 로 결과를 반환시켜 줌
	// (반환 타입이 void이면 return;으로 메소드를 종료시킴)
	{
		double size = HigherMathmatics.getTriangleSize(10, 0);
		System.out.println(size);
		double circleSize = HigherMathmatics.getCircleSize(5);
		System.out.println(circleSize);
		
	}

}
