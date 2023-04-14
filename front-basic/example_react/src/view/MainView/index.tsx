import React, { useRef, useState } from 'react'
import NaverInput from '../../component/InputComponent';
import NaverFind from '../../component/FindComponent';

const FIND_LIST = [
    {
        title: '비밀번호 찾기',
        link: 'https://nid.naver.com/user2/api/route?m=routePwInquiry&lang=ko_KR'
    },
    {
        title: '아이디 찾기',
        link: 'https://nid.naver.com/user2/api/route?m=routeIdInquiry&lang=ko_KR'
    },
    {
        title: '회원가입',
        link: 'https://nid.naver.com/user2/V2Join?m=agree&lang=ko_KR'
    }
];

export default function Main() {
    // * 스크립트문 쓰는 법

    // @ form
    const formRef = useRef<HTMLFormElement | null>(null);

    // @ 상태 변수 
    // # 상태를 계속 주시하고 있다가 return을 다시 뿌린다
    // #비구조화 할당
    // @ 사용자가 입력한 값을 받는 상태 변수
    const [id, setId] = useState<string>('');
    const [password, setPassword] = useState<string>('');

    //-----상태명   //상태를 변경해주는 메소드      //초기값
    const [isIdCheck, setIdCheck] = useState<boolean>(false);



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
    return (

        <div className="main">
            <div className="content">

                <div className="sign-in-wrapper">

                    <form ref={formRef} id="form" action="https://nid.naver.com/nidlogin.login" method="POST">
                        <ul className="panel-wrapper">
                            <li className="panel-item">
                                <div className="panel-inner">
                                    <div className="id-password-wrapper">

                                        <NaverInput label='아이디' type='text' name='id' maxLength={41} iconClass='icon-id' setter={setId} />
                                        <NaverInput label='비밀번호' type='password' name='pw' maxLength={16} iconClass='icon-pw' setter={setPassword} />

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
                    {
                        // 배열 foreach 같은 역할
                        FIND_LIST.map((findItem) => (<NaverFind title={findItem.title} link={findItem.link} />))
                    }
                </ul>
                <div className="banner-wrapper">
                    <div className="banner-content">
                        <img className="banner-image"
                            src="https://ssl.pstatic.net/melona/libs/1378/1378592/12ac0aee177c4a9f226f_20230405154307970.jpg" />
                    </div>
                </div>
            </div>
        </div>);
}
