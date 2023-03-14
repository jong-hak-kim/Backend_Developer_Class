package chapter2.A_Jf;

// if 구문
// 조건에 따라 실행시키고자 하는 로직(프로세스)이 다를 때 사용하는 구문
public class If {
	public static void main(String[] args) {
		// 단순 if문
		// 조건이 true일 때 실행할 코드를 지정하는 구문
		// 사용 방법 : if (조건) {조건이 true일 때 실행할 코드};
		int age = 12;
		if (age > 19) {
			System.out.println("성인입니다.");
		}
		// if문의 경우 코드 블럭에 오는 실행할 코드가 하나의 구문이면
		// {}를 제거하고 사용 가능
		if (age > 19)
			System.out.println("성인입니다.");

		System.out.println("조건 검사 완료");

		// if - else문
		// 조건이 true일 경우와 false일 경우 실행되는 코드를 각각 지정한 구문
		// 사용 방법 :
		// if (조건) { true일 때 실행할 코드 }
		// else { false일 때 실행할 코드 }
		if (age > 19) {
			System.out.println("성인입니다.");
		} else {
			System.out.println("미성년자입니다.");
		}

		// if 문과 마찬가지로 else 문도 코드 블럭에 오는 실행할 코드가
		// 하나의 구문이면 {}를 제거하고 사용 가능
		if (age > 19)
			System.out.println("성인입니다.");
		else
			System.out.println("미성년자입니다.");

		// 중첩 if문
		// if문 혹은 else문의 코드 블럭 안에 if문을 작성
		if (age <= 19) {
			if (age < 8)
				System.out.println("미취학 아동입니다.");
			else
				System.out.println("청소년입니다.");
		} else {
			System.out.println("성인입니다.");
		}

		if (age > 19)
			System.out.println("성인입니다.");
		else if (age < 8)
			System.out.println("미취학 아동입니다.");
		else
			System.out.println("청소년 입니다.");

		// if - else if - else 문
		// 중첩 if문의 응용
		// else 문의 코드 블럭에 오는 코드가 한 줄일 때 {}을 제거할 수 있음을 이용
		if (age > 19) {
			System.out.println("성인입니다.");
		} else if (age < 8) {
			System.out.println("미취학 아동입니다.");
		} else {
			System.out.println("청소년입니다.");
		}
	}
}
