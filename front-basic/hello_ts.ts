console.log('Hello Typescript!');

// @ 변수
// # 변수이름 : 타입
// # 타입을 지정하여 그 타입의 값만 받도록 한다
let number: number;
number = 10;
// number = 'string';

// # 값이 처음에 들어올 때 묵시적으로 타입을 지정한다
let string = 'string';
// string = 10;

// @ 함수
// # 반환 타입을 지정해주고 싶을 시 매개변수 괄호 뒤에 콜론을 사용하여 타입 지정
// # any는 모든 타입
// # 매개변수도 타입을 지정해주어야 한다
const funtion = (arg: number): string => {
    return 'string';
}

// @ 객체
// * 1. class를 이용
class Object1 {
    prop1: string;
    prop2: number;

    constructor(prop1: string, prop2: number) {
        this.prop1 = prop1;
        this.prop2 = prop2
    };
};
const object1: Object1 = { prop1: 'prop1', prop2: 2 };

// # constructor를 매번 쓰기 귀찮으므로 다른 방법이 존재
// * 2. type 키워드 사용 (json 형태로 받는다)
type Object2 = {
    prop1: string,
    prop2: number
}
const object2: Object = { prop1: 'prop1', prop2: 2 };

// # 클래스는 100%로 구성되어있지만 인터페이스는 완전히 구성되어 있지 않다
// * 3. interface 활용 (타입스크립트에서만 사용 가능)
interface Object3 {
    prop1: string;
    prop2: number;
    // @ 함수의 타입을 미리 지정
    // # 매개변수를 number로 받는 타입 하나가 있고 반환 타입이 string이다
    // @ 현재 func1은 필수로 잡혀있다
    // # 변수 이름 뒤에 ?를 붙여서 필수가 아닌 선택적인 함수로 만들어 준다
    func1?: (arg1: number) => string;
}
// @ 타입스크립트에서는 객체를 널로 지정할 수 없다
// # 무조건 값을 필수로 넣어야 한다
// * 하지만 널로 먼저 선언하고 나중에 따로 타입 지정하려면 선언한 얘 뒤에 | null = null 을 붙여서 선언한다
const object3: Object3 | null = null;

// @ 타입 합치기
interface Object4 {
    prop3: string;
    prop4: number;
}

// # Object3와 Object4의 속성을 동시에 가지겠다
// # 타입을 합친 것
const object4: Object3 & Object4 = {
    prop1: 'prop1', prop2: 2, prop3: 'prop3', prop4: 4
}

// * 4. enum
enum Fruits {
    APPLE = '사과',
    BANANA = '바나나',
    MELON = '메론'
}

// # 특정한 값만 넣을 수 있다
const fruit : Fruits = Fruits.APPLE ;
console.log(fruit);

