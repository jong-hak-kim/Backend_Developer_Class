import React, { useState } from 'react';
import logo from './logo.svg';
import './naver-sign-in.css';
import { useRef } from 'react';

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
function App() {
  // * return에는 자식 요소가 하나만 올 수 있다 (하나의 요소만 반환 가능)
  // ! 제일 최상위 요소를 하나로만 맞춰주면 된다 (<> </> 사이에 HTML 코드 입력)
  // # style을 쓸 때 중괄호로 타입스크립트문 사용할 수 있게 해주고 중괄호를 하나 더 사용하여 오브젝트를 생성하여 사용 한다
  // # ex) style={{display: 'none'}}


  // * 스크립트문 쓰는 법

  // @ form
  const formRef = useRef<HTMLFormElement | null>(null);

  // @ 상태 변수 
  // # 상태를 계속 주시하고 있다가 return을 다시 뿌린다
  // #비구조화 할당
  //-----상태명   //상태를 변경해주는 메소드      //초기값
  const [isIdCheck, setIdCheck] = useState<boolean>(false);
  // @ 사용자가 입력한 값을 받는 상태 변수
  const [id, setId] = useState<string>('');

  // # isIdCheck는 변수라서 그냥 값만 가져온 것이다
  // # 변수의 값을 변경해서는 상태를 변경할 수 없고
  // # setIdCheck처럼 메소드를 이용하여 상태를 변경할 수 있다

  // @ 변수
  // # 아무리 변수를 바꿔서 넣더라도 작업이 되지 않는다

  const onSubmitHandler = () => {
    if (!id.trim()) {
      setIdCheck(true);
      return;
    }
    setIdCheck(false);

    // # formRef가 존재하면 submit을 해라
    if (formRef.current)
    formRef.current.submit();
    // # current? null이어도 실행을 하지 않고 존재할 경우에만 실행
    // # formRef.current?.submit();
  }

  // ! onclick 사용
  // # onclick에는 함수 호출이 아니라 함수를 넣어야 한다 (함수 그 자체를 넣거나 익명 함수 만들거나)
  // @ onClick={onSubmitHandler()} -> onClick={onSubmitHandler} 
  // * 또는 익명의 함수를 만들어줘도 된다
  // @ onClick={onSubmitHandler()} -> onClick={() => onSubmitHandler()}
  return (
    <>
      <div className="header">
        <div className="header-inner">
          <a href="https://naver.com" className="logo">
            <h1 className="blind">NAVER</h1>
          </a>
          <div className="lang">
            <select className="select">
              <option>한국어</option>
              <option>English</option>
            </select>
          </div>
        </div>
      </div>
      <div className="main">
        <div className="content">

          <div className="sign-in-wrapper">

            <form ref={formRef} id="form" action="https://nid.naver.com/nidlogin.login" method="POST">
              <ul className="panel-wrapper">
                <li className="panel-item">
                  <div className="panel-inner">
                    <div className="id-password-wrapper">
                      <div className="input-row">
                        <div className="icon-cell">
                          <span className="icon-id"><span className="blind">아이디</span></span>
                        </div>
                        {/* onChange input에 있는 값이 바뀔 때마다 호출한다 */}
                        {/* 사용자가 입력한 행위를 받아오기 때문에 setID로 값 전달  */}
                        <input type="text" className="input-text" maxLength={41} placeholder="아이디" name="id" onChange={(event) => setId(event.target.value)} />
                      </div>
                      <div className="input-row">
                        <div className="icon-cell">
                          <span className="icon-pw">
                            <span className="blind">비밀번호</span>
                          </span>
                        </div>
                        <input type="password" className="input-text" maxLength={16} placeholder="비밀번호" name="pw" id="pw" />
                      </div>
                    </div>


                    <div className="sign-in-keep-wrapper">
                      <div className="keep-check">
                        <input type="checkbox" className="input-keep" value="off" />
                        <label className="keep-text">로그인 상태 유지</label>
                      </div>
                      <div className="ip-check"></div>
                    </div>

                    {/* 중괄호 안에 있는 소괄호 안에 HTML문들을 넣어준다
                    isIdCheck는 false로 위에서 지정해주었다. 
                    return 안에서는 If문을 사용할 수 없다
                    if else를 쓰려면 삼항 연산자로 사용
                    모든 것은 연산자로 처리한다
                    */}
                    {isIdCheck && (
                      <div id="sign-in-error" className="sign-in-error" >
                        <div className="error-message">
                          <strong>아이디</strong>를 입력하세요.
                        </div>
                      </div>
                    )}


                    <div className="sign-in-button-wrapper">
                      <button type="button" className="sign-in-button" onClick={() => onSubmitHandler()}>
                        <span className="button-text">로그인</span>
                      </button>
                    </div>
                  </div>
                </li>
              </ul>
            </form>
          </div>
          <ul className="find-wrapper">
            <li>
              <a className="find-text" href="https://nid.naver.com/user2/api/route?m=routePwInquiry&lang=ko_KR">비밀번호 찾기</a>
            </li>
            <li>
              <a className="find-text" href="https://nid.naver.com/user2/api/route?m=routeIdInquiry&lang=ko_KR">아이디 찾기</a>
            </li>
            <li>
              <a className="find-text" href="https://nid.naver.com/user2/V2Join?m=agree&lang=ko_KR">회원가입</a>
            </li>
          </ul>
          <div className="banner-wrapper">
            <div className="banner-content">
              <img className="banner-image"
                src="https://ssl.pstatic.net/melona/libs/1378/1378592/12ac0aee177c4a9f226f_20230405154307970.jpg" />
            </div>
          </div>
        </div>
      </div>
      <div className="footer">
        <div className="footer-inner">
          <ul className="footer-link">
            <li>
              <a className="footer-item"><span className="text">이용약관</span></a>
            </li>
            <li>
              <a className="footer-item"><span className="text"><strong>개인정보처리방침</strong></span></a>
            </li>
            <li>
              <a className="footer-item"><span className="text">책임의 한계와 법적고지</span></a>
            </li>
            <li>
              <a className="footer-item"><span className="text">회원정보 고객센터</span></a>
            </li>
          </ul>
          <div className="footer-copy">
            <a href="https://www.navercorp.com"><span className="footer-logo">
              <span className="blind">네이버</span>
            </span></a>
            <span className="text">Copylight</span>
            <span className="copy">© NAVER Corp.</span>
            <span className="text">All Rights Reserved.</span>
          </div>
        </div>
      </div>
    </>

  );
}

export default App;
