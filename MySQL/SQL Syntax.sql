# 내용 
-- 띄어쓰기 해야 주석이 됨
/* 부분 주석 */
/*
여러 줄
주석
*/

# DDL (데이터 정의어)
# 데이터베이스 혹은 테이블(뷰, 인덱스, 프로시저...)을 생성, 수정, 삭제 할 때 사용하는 SQL문

# CREATE 문
# 데이터베이스나, 테이블 등을 생성할 때 사용하는 SQL문

# 데이터베이스 생성
# CREATE DATABASE 데이터베이스명;

CREATE DATABASE Hotel;

SHOW DATABASES;

# 데이터베이스를 생성했으면 사용할 데이터베이스를 선택
# USE 데이터베이스명;

USE Hotel;

# 테이블 생성
# CREATE TABLE 테이블명 (
#   필드명 데이터타입(데이터길이) 제약조건,
#   ...
# );

CREATE TABLE Custom (
	id INT PRIMARY KEY, -- NOT NULL과 UNIQUE 특징 가짐
    name VARCHAR(20) NOT NULL,
    email VARCHAR(30) UNIQUE, -- 중복 방지
    age INT,
    address TEXT,
    accept_marketing BOOLEAN DEFAULT false -- 기본값을 false로 설정한다 (값을 넣지 않더라도 false로 들어가게 된다)
    -- 필드명에 띄어쓰기가 있으면 띄어쓰기 대신 _ 사용
);

SHOW TABLES;

# 데이터베이스 수정
# ALTER DATABASE 데이터베이스명 속성명 = 값;

# 테이블 수정
# ALTER TABLE 테이블명

# 테이블 필드 추가
# ALTER TABLE 테이블명 ADD 필드명 데이터타입(데이터길이) 제약조건;
# 테이블 필드 삭제
# ALTER TABLE 테이블명 DROP 필드명;
# 테이블 필드 수정
# ALTER TABLE 테이블명 MODIFY COLUMN 필드명 데이터타입(데이터길이) 제약조건;

# 데이터베이스 삭제
# DROP DATABASE 데이터베이스명;

# 테이블 삭제
# DROP TABLE 테이블명;
# TRUNCATE TABLE 테이블명;

# DROP TABLE 테이블명 : 테이블의 정의 자체를 제거
# TRUNCATE TABLE 테이블명 : 테이블을 정의만 남기고 모두 제거 (생성 초기 상태로 돌려놓음)











