import React from 'react'

// @ export 요소;로 내보낸 요소는 import할 때 내보낸 요소의 이름과 동일한 이름으로 받야아 함
// # import {요소,요소, ...}
// @ export default 요소;로 내보낸 요소는 import할 때 내보낸 요소의 이름과 달라도 됨
export default function Header() {
  return (
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
  );
}
