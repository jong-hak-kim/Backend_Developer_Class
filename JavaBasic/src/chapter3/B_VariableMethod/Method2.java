package chapter3.B_VariableMethod;

class Triangle {
	double underside;
	double height;
	double diagonal;

	double area;
	double circumference;
}

class TriangleMath {

	// 파라미터로 참조 변수를 받는다면 메모리 주소가 복사돼서 넘어오기 때문에
	// 실제 작업도 해당 메모리 주소에서 작업을 진행함
	// 실제 데이터가 변경됨
	static void setArea(Triangle triangle) {
		double area = 0.5 * triangle.underside * triangle.height;
		triangle.area = area;
	}

	static void setDiagonal(Triangle triangle) {
		double squareDiagonal = Math.pow(triangle.underside, 2) + Math.pow(triangle.height, 2);
		double diagonal = Math.sqrt(squareDiagonal);
		triangle.diagonal = diagonal;
	}

	static void setCircumference(Triangle triangle) {
		triangle.circumference = triangle.underside + triangle.height + triangle.diagonal;
	}

	static Triangle createTriangle(double underside, double height) {
		Triangle triangle = new Triangle();
		triangle.underside = underside;
		triangle.height = height;
		setDiagonal(triangle);
		setArea(triangle);
		setCircumference(triangle);
		return triangle;
	}
}

public class Method2 {

	public static void main(String[] args) {
		Triangle triangle1 = new Triangle();
		triangle1.underside = 3;
		triangle1.height = 4;
		triangle1.diagonal = 5;

		TriangleMath.setArea(triangle1);
		System.out.println(triangle1.area);

		Triangle triangle2 = TriangleMath.createTriangle(5, 5);
		System.out.println(triangle2.area);
	}

}
