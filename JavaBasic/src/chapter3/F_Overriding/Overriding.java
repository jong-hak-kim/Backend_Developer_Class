package chapter3.F_Overriding;

// 오버라이딩
// 조상 클래스로부터 상속받은 메소드의 내용을 변경하는 것
// 상속받은 메소드를 자손 클래스에 맞게 변경시키고자 할 때 오버라이딩을 사용

class Human {
	String name;
	
	void eat(String food) {
		System.out.println(this.name + "가 " + food + "를 먹습니다.");
		
	}
}

class Developer extends Human{
	// Overload
	void eat() {
		System.out.println(super.name + "가 식사를 합니다.");
	}
	
	
	// Override
	void eat(String food) {
		System.out.println(super.name + "가 " + food + "를 절반만 먹습니다.");
	}
}

public class Overriding {
	public static void main(String[] args) {
		Developer developer = new Developer();
		developer.name = "John doe";
		
		developer.eat("사과");
		developer.eat();
		
		Human human = new Human();
		
		human.name = "Michle";
		
		human.eat("바나나");
}
}
