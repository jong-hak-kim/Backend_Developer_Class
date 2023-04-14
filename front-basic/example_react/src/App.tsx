import React, { Dispatch, SetStateAction, useState } from 'react';
import logo from './logo.svg';
import './naver-sign-in.css';
import { useRef } from 'react';
import Header from './view/HeaderView';
import Footer from './view/FooterView';
import Main from './view/MainView';

// @ App.tsx
// * App.ts까지는 타입스트립트인데 뒤에 x가 붙어 XML 사용
// * tsx : typescript XML(XHTML)
// * jsx : javascript XML
// # 그러므로 완벽한 문법을 요구
// # 대소문자 구분
// # 숫자를 입력하려면 중괄호{} 안에 입력해주어야 한다(그냥 입력하면 문자로 인식)
// # 클래스 작성 시 classNameName으로 작성
// # 에러를 뱉어준다
// ! 리액트에서 함수가 대문자로 시작하는 함수는 컴포넌트로 인식


// @ 강제성을 부여하기 위해 인터페이스 생성

// @ 일반적으로 값을 받아오면 안 되고 객체로 받아와야 한다

function App() {
  // * return에는 자식 요소가 하나만 올 수 있다 (하나의 요소만 반환 가능)
  // ! 제일 최상위 요소를 하나로만 맞춰주면 된다 (<> </> 사이에 HTML 코드 입력)
  // # style을 쓸 때 중괄호로 타입스크립트문 사용할 수 있게 해주고 중괄호를 하나 더 사용하여 오브젝트를 생성하여 사용 한다
  // # ex) style={{display: 'none'}}




  // # isIdCheck는 변수라서 그냥 값만 가져온 것이다
  // # 변수의 값을 변경해서는 상태를 변경할 수 없고
  // # setIdCheck처럼 메소드를 이용하여 상태를 변경할 수 있다

  // @ 변수
  // # 아무리 변수를 바꿔서 넣더라도 작업이 되지 않는다



  // ! onclick 사용
  // # onclick에는 함수 호출이 아니라 함수를 넣어야 한다 (함수 그 자체를 넣거나 익명 함수 만들거나)
  // @ onClick={onSubmitHandler()} -> onClick={onSubmitHandler} 
  // * 또는 익명의 함수를 만들어줘도 된다
  // @ onClick={onSubmitHandler()} -> onClick={() => onSubmitHandler()}
  return (
    <>
      <Header />
      {/* 위 Main 컴포넌트에 값을 전달
        HTML 속성값 지정하듯이 적어야 함
      */}
      <Main />
      <Footer />
    </>

  );
}

export default App;
