package chapter5.B_ApiClass;

import java.util.Random;
import java.util.Scanner;

// API class
// Java 자체에서 제공해주는 개발에 도움을 주는 각종 라이브러리

public class ApiClass {
	public static void main(String[] args) {
		// Object class
		// 모든 class의 조상 class
		Object object = new Scanner(System.in);
		object = new int[10];

		// String class
		// 문자열 처리에 대한 메소드가 정의되어 있는 클래스
		String string = " This is string contents ";

		// .substring(시작 인덱스, 종료 인덱스);
		String subString = string.substring(6, 8);
		System.out.println(subString);

		// .length()
		// 문자열 길이 가져오는 메소드

		// .toUpperCase();
		// 모든 문자를 대문자로 교체
		// .toLowerCase();
		// 모든 문자를 대문자로 교체
		String upperCase = string.toUpperCase();
		String lowerCase = string.toLowerCase();

		System.out.println(upperCase);
		System.out.println(lowerCase);

		// indexOf(문자열);
		// 해당하는 문자열이 존재한다면 그 위치의 첫 번째 인덱스 번호를 반환
		// 해당하는 문자열이 존재하지 않으면 -1 반환
		int stringIndex = string.indexOf("ais");
		System.out.println(stringIndex);

		// .trim();
		// 문자열의 앞뒤 공백 제거
		String trimString = string.trim();
		System.out.println(trimString);

		// . replaceAll(변환할 문자열, 변환될 문자열);
		// 특정 문자열을 지정한 문자열로 변경
		String replaceString = string.replaceAll("is", "are");
		System.out.println(replaceString);

		// Wrapper class
		// 기본형 데이터 타입을 참조형 데이터 타입으로 다루기 위한 클래스
		// int -> Integer
		// double -> Double
		// ...

		Integer integer = 10;
		int number = integer;

		// 문자열 -> 숫자
		String numberString = "110";
		number = Integer.parseInt(numberString);
		System.out.println(number);

		// 숫자 -> 문자열
		numberString = Integer.toString(550);
		System.out.println(numberString);

		// Random class
		// 무작위의 값을 얻고자 할 때 유용한 클래스
		Random random = new Random();
		// .nextInt() : 무작위의 int형 정수
		// .nextLong() : 무작위의 long형 정수
		// .nextInt(최대값) : 최대값보다 작은 int 정수
		int randomNumber = random.nextInt(3);
		System.out.println(randomNumber);

		int[] lotto = new int[6];

		for (int index = 0; index < lotto.length; index++) {
			boolean equal = false;
			int lottoNumber = random.nextInt(45) + 1;
			for (int subIndex = 0; subIndex < index; subIndex++) {
				if (lotto[subIndex] == lottoNumber) equal = true;
			}
			
			if (equal) {
				--index;		
				continue;
			}
			lotto[index] = lottoNumber;
		}

		for (int lottoNumber : lotto) {
			System.out.print(lottoNumber + " ");
		}
		
		
		
	}
}
