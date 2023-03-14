package chapter6.B_Generic;

// 제너릭
// 다양한 타입을 다루는 메소드나 클래스에 컴파일 시 타입을 체크하는 기능
// 컴파일 시 타입을 체크하기 때문에 유연하게 개발을 할 수 있음

class GenericClass<D> {

	boolean status;
	String message;
	D data; // 데이터 값이 어떤 타입으로 들어갈지 모르기 때문에 제너릭으로 해놓는다
	// 외부에서 받은 타입으로 data를 지정하겠다

	static <D> GenericClass<D> getInstance(boolean status, String message, D data) {
		GenericClass<D> instance = new GenericClass<>();
		instance.status = status;
		instance.message = message;
		instance.data = data;
		return instance;

	}
}

public class Generic {
	public static void main(String[] args) {
		GenericClass<Integer> generic1 = new GenericClass<>(); // 참조변수를 선언할 때 제너릭에 타입을 넣어준다
		GenericClass<String> generic2 = new GenericClass<>();

//		generic1.data = "String"; // 에러 발생
		generic2.data = "String";
		
		GenericClass<?> generic3 = GenericClass.getInstance(true, "message", "String");
	}
}
