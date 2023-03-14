package chapter3.D_Constructor;

// 생성자
// 인스턴스가 생성될 때 호출되는 인스턴스 '초기화 메소드'
// 인스턴스 변수의 초기화 작업에 사용
// 인스턴스 생성 시에 실행되어야 할 작업을 작성하는 위치

// 생성자의 조건
// 생성자의 이름은 해당 클래스명과 동일
// 생성자는 반환 값이 없음
class Circle {
	double radius;
	double diameter;
	double circumference;
	double area;

	// 생성자 사용 방법
	// 클래스명([파라미터[, ...]]) { 인스턴스 생성 시 실행할 코드 }
	Circle(double radius) {
		System.out.println("Circle이 생성됩니다.");
		// this : 인스턴스 자신
		this.radius = radius;
		this.diameter = 2 * radius;
		this.circumference = 3.14 * 2 * radius;
		this.area = 3.14 * radius * radius;
	}

	// 생성자도 메소드이기 때문에 오버로딩을 적용해서
	// 매개변수에 따라 다른 작업을 수행하게 할 수 있음
	Circle() {
		System.out.println("빈 생성자입니다.");
		this.radius = 10;
		this.diameter = 2 * this.radius;
		this.circumference = 3.14 * this.diameter;
		this.area = 3.14 * this.radius * this.radius;
	}

	// 생성자를 이용한 인스턴스 복사
	Circle(Circle circle) {
		this.radius = circle.radius;
		this.diameter = circle.diameter;
		this.circumference = circle.circumference;
		this.area = circle.area;
	}
}

public class Constructor {

	public static void main(String[] args) {

		System.out.println("===생성자===");
		Circle circle1 = new Circle();
		Circle circle2 = new Circle(5);
		System.out.println("============");

		System.out.println(circle1.area);
		System.out.println(circle2.area);

	}

}
