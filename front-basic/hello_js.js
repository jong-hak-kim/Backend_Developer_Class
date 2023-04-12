// console.log("Hello Javascript!");

// 한줄 주석
/* 부분 주석 */

// ! 변수 선언 방법 //
// @ 1. 변수의 타입이 존재하지 않음
var variable_name;
var variable_name = "변수 값";
console.log(variable_name.trim());
variable_name = 10;
// * 정수에는 trim이 없으므로 오류가 난다
// console.log(variable_name.trim());
// @ 2. 변수 선언 키워드
// * var, let, const
var variable_name;
if (10 == 10) {
  var variable_name2 = "변수";
}
console.log(variable_name2);

let let_variable_1;
// let let_variable_1;
if (10 == 10) {
  let let_variable_2 = "블럭 변수";
}
// console.log(let_variable_2);

// * const 상수 (한번 선언하면 변경이 되지 않는다)
const const_variable_1 = "상수";
// const_variable_1 = "변경 상수";

// @ 3. 데이터의 타입
// * 문자열 string : '', ""
// # let stringVariale1 = '문자열';
// # let stringVariale2 = "문자열";
// # 타입 확인 typeof
// console.log(typeof (stringVariale1, stringVariale2));

// * 숫자 number : 정수, 실수
let numberVariable1 = 10;
let numberVariable2 = 1.5;
console.log(typeof (numberVariable1, numberVariable2));

// * 논리 boolean : true, false
let booleanVariable = true;
console.log(typeof booleanVariable);

// * null
let nullVariable = null;
console.log(typeof nullVariable);

// * 배열 : []
let arrayVarialbe = [1, "A", false];
arrayVarialbe[0];

// * 객체 : {}
let objectVariable = {
  "key": "value",
  "name": "John",
  "age": 20,
  "object": {
    "key1": 1
  }
};

// * 1. 나눗셈 연산자
let number1 = 10 / 3;
console.log(number1)
// * 2. 제곱 연산자 (**)
let number2 = 10 ** 3;
console.log(number2)
// * 3. 비교연산 ==, ===
//  # == 문자로 다 변환하여 비교
//  # === 데이터 타입도 확인하여 비교
let numberValue10 = 10;
let stringValue10 = '10';
console.log(numberValue10 == stringValue10);
console.log(numberValue10 === stringValue10);

// * if 조건
// * 값이 0 이거나 없으면 빈 값이므로 false
// * 자바스크립트에서 object 계열은 주소값을 미리 만드므로 공백이더라도 true이다
// * object에 대한 빈 값은 null이다
let tmpValue = null;
if (tmpValue) console.log('true');
else console.log('false');

// @ class
// ! 자바스크립트에서는 클래스는 중요하지 않다 
// # 아무 의미가 없고 메소드를 정의해서 쓰는 것도 아니고 객체를 클래스 없이 만들 수도 있기 때문이다
// # 틀에 완전히 맞춰야 하는 조건이 있다면 자바에서 쓰는 것처럼 new 객체로 만들 수 있다. (하지만 거의 안 씀)
class Human {
  name;
  age;
  address;
  // # 생성자는 하나만 만들 수 있다
  constructor(name, age, address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }
}

let humanObject = new Human('John', 30, '부산');
// # 객체 접근
console.log(humanObject.name);
// # undefined
console.log(humanObject.nema);

// ! 자바스크립트에서 객체 다루기
// @ 비구조화 할당
// * 보통 get으로 받아오지만 자바스크립트에서는 객체에 있는 애들을 그대로 분해할 수 있다
// const { name, age, address } = humanObject;
let { name, ...others } = humanObject;
console.log(name);
console.log(others);

// * 값을 바꾸고 싶을 때
name = 'Micle';
// * 스프레드 연산자를 이용하여 뒤에 오는 항목과 중첩되면 원래 있던 값을 날리고 뒤에 있는 값으로 덮어씌운다
humanObject = { ...humanObject, name };
//# 위에 코드는 이렇게 된다 => { name, age, address, name } 하지만 중첩되어 뒤에 name이 원래 humanObject 자리로 들어간다 
console.log(humanObject)

const tmpArray = [1, 'A', true];
const [number, ...otherArray] = tmpArray;
console.log(number);
console.log(otherArray);

// @ 함수
// # 클래스나 인스턴스 내부에 있으면 메소드
// # 밖에 있으면 함수
// # 타입 없이 매개변수를 받는다
// # 변수에 저장되는 공간이 한정되어 있지 않다
function function1(arg, arg2) {

}

function1(1, 2);

// # 메모리 공간에 대한 이름 지정
const function2 = (arg1, arg2) => {

}

function2(1, 2);

