package chapter4.C_AbstractClass;

// 추상 클래스
// 추상 메소드가 포함되어 있는 클래스
// 추상 클래스로 인스턴스를 생성할 수 없음

// 사용 방법 :
// abstract class 클래스명 {}
abstract class Abstract {
	int number1;
	
	// 추상 메소드
	// 선언부만 작성이 되어 있고 구현부는 작성되어 있지 않은 메소드
	// 해당 클래스를 상속받은 자손 클래스에서 구현을 필수로 요구함
	
	// 사용 방법 :
	// abstract 반환타입 메서드명([매개변수]);
	abstract void method1();
}

class SubClass extends Abstract {
	void method1() {
		System.out.println("구현!");
	}
}

public class AbstractClass {
	public static void main(String[] args) {
		Abstract abstract1 = new SubClass();
		
	}
}
