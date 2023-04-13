console.log('Hello Typescript!');
// @ 변수
// # 변수이름 : 타입
// # 타입을 지정하여 그 타입의 값만 받도록 한다
var number;
number = 10;
// number = 'string';
// # 값이 처음에 들어올 때 묵시적으로 타입을 지정한다
var string = 'string';
// string = 10;
// @ 함수
// # 반환 타입을 지정해주고 싶을 시 매개변수 괄호 뒤에 콜론을 사용하여 타입 지정
// # any는 모든 타입
// # 매개변수도 타입을 지정해주어야 한다
var funtion = function (arg) {
    return 'string';
};
// @ 객체
// * 1. class를 이용
var Object1 = /** @class */ (function () {
    function Object1(prop1, prop2) {
        this.prop1 = prop1;
        this.prop2 = prop2;
    }
    ;
    return Object1;
}());
;
var object1 = { prop1: 'prop1', prop2: 2 };
var object2 = { prop1: 'prop1', prop2: 2 };
// @ 타입스크립트에서는 객체를 널로 지정할 수 없다
// # 무조건 값을 필수로 넣어야 한다
// * 하지만 널로 먼저 선언하고 나중에 따로 타입 지정하려면 선언한 얘 뒤에 | null = null 을 붙여서 선언한다
var object3 = null;
// # Object3와 Object4의 속성을 동시에 가지겠다
// # 타입을 합친 것
var object4 = {
    prop1: 'prop1', prop2: 2, prop3: 'prop3', prop4: 4
};
// * 4. enum
var Fruits;
(function (Fruits) {
    Fruits["APPLE"] = "\uC0AC\uACFC";
    Fruits["BANANA"] = "\uBC14\uB098\uB098";
    Fruits["MELON"] = "\uBA54\uB860";
})(Fruits || (Fruits = {}));
// # 특정한 값만 넣을 수 있다
var fruit = Fruits.APPLE;
console.log(fruit);
