USE KJH_BOARD;

# 회원가입
INSERT INTO USER 
(email, password, nickname, tel_number, address, address_detail, consent_personal_information)
VALUES ('whdgkr9070@naver.com', sha2('P!ssw0rd', 512), 'jonghak', '010-1111-2222', '부산광역시', '부산서구', true);

# 로그인
# 패스워드 암호화가 되어있지 않을 때
SELECT * FROM USER
WHERE email = 'whdgkr9070@naver.com'
AND password = 'P!ssw0rd';
# 패스워드 암호화가 되어 있을 때
SELECT * FROM USER
WHERE email = 'whdgkr9070@naver.com';

# 게시물 작성
INSERT INTO Board(title, content, board_image_url, write_datetime, writer_email)
VALUES ('Test Title', 'Test Content', null, now(), 'whdgkr9070@naver.com');

# 게시물 보기
SELECT *
FROM Board B, User U, 
(SELECT B.board_number AS board_number, count(L.user_email) AS like_cout
FROM Board B
LEFT JOIN Likey L
ON B.board_number = L.board_number
GROUP BY B.board_number) LC,
(
SELECT B.board_number AS board_number, count(C.user_email) AS comment_count
FROM Board B
LEFT JOIN Comment C
ON B.board_number = C.board_number
GROUP BY board_number
) CC
WHERE B.board_number = 1
AND B.writer_email = U.email
AND B.board_number = LC.board_number
AND B.board_number = CC.board_number;

SELECT * FROM Likey L, User U
WHERE L.user_email = U.email
AND L.board_number = 1;

SELECT * FROM Comment C, USER U
WHERE C.user_email = U.email
AND C.board_number = 1;

CREATE VIEW Board_View AS
SELECT 
B.board_number AS board_number,
B.title AS title,
B.content AS content,
B.write_datetime AS write_datetime,
B.board_image_url AS board_image_url,
U.email AS writer_email,
U.nickname AS writer_nickname,
U.profile_url AS writer_profile_url,
LC.like_count AS like_count,
CC.comment_count AS comment_count
FROM Board B, User U, 
(SELECT B.board_number AS board_number, count(L.user_email) AS like_count
FROM Board B
LEFT JOIN Likey L
ON B.board_number = L.board_number
GROUP BY B.board_number) LC,
(
SELECT B.board_number AS board_number, count(C.user_email) AS comment_count
FROM Board B
LEFT JOIN Comment C
ON B.board_number = C.board_number
GROUP BY board_number
) CC
WHERE B.writer_email = U.email
AND B.board_number = LC.board_number
AND B.board_number = CC.board_number;

SELECT * FROM Board_View
WHERE board_number = 1;

# 최신 게시물 리스트
SELECT * FROM Board_View
ORDER BY write_datetime DESC;

# 주간 TOP 3
SELECT * FROM Board_View
WHERE write_datetime >= '2023-03-27'
ORDER BY like_count DESC
LIMIT 3;

# 검색어
SELECT 
    *
FROM
    Board_View
WHERE
    title LIKE '%Title%'
        OR content LIKE '%Title%';

# 내 게시물 리스트
SELECT * FROM Board_View
WHERE writer_email = 'whdgkr9070@naver.com';

# 좋아요
INSERT INTO Likey (user_email, board_number)
VALUE ('whdgkr9070@naver.com', 1);

# 좋아요 취소
DELETE FROM Likey 
WHERE
    user_email = 'whdgkr9070@naver.com'
    AND board_number = 1;

# 댓글 작성
INSERT INTO Comment (user_email, board_number, comment_content, write_datetime)
VALUES ('whdgkr9070@naver.com', 1, 'Test Comment', now());

# 게시물 수정
UPDATE Board 
SET 
    title = 'Modified Title',
    content = 'Modified Content',
    board_image_url = 'http://~~'
WHERE
    board_number = 1;

# 게시물 삭제
DELETE FROM Comment
WHERE board_number = 1;

DELETE FROM Likey
WHERE board_number = 1;

DELETE FROM Board
WHERE board_number = 1;

# 검색 로그
INSERT INTO Search_Log (search_word) VALUES ('Title');
INSERT INTO Search_Log (search_word, related_search_word)
VALUE ('modify', 'Title');

# 인기 검색어
SELECT 
    search_word, COUNT(search_word) AS count
FROM
    Search_Log
GROUP BY search_word
ORDER BY count DESC
LIMIT 10;

# 연관 검색어
SELECT 
    related_search_word, COUNT(related_search_word) AS count
FROM
    Search_Log
WHERE
    search_word = 'modify'
GROUP BY related_search_word
ORDER BY count DESC
LIMIT 10;