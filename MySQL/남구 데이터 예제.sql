# Namgu 테이블에서 전체 필드 검색
SELECT * FROM Namgu;
# Namgu 테이블에서 구분, 세대수, 면적 검색
SELECT 구분, 세대수, 면적
FROM namgu;

# Namgu 테이블에서 구분, 세대수, 면적 필드 중 중복을 제거하여 검색
SELECT DISTINCT 구분, 세대수, 면적
FROM namgu;

# Namgu 테이블에서 조건 검색
SELECT * FROM Namgu WHERE 구분 = '문현2동 ';
SELECT * FROM Namgu WHERE 구성비 = 3;

SELECT * FROM Namgu WHERE 구분 LIKE '문현%';
SELECT * FROM Namgu WHERE 구분 LIKE '%문현%'; #문현이란 단어 자체가 포함되어있으면 출력
 
SELECT * FROM Namgu WHERE 세대수 >= 10000;
SELECT * FROM Namgu WHERE 세대수 <= 5000;

SELECT * FROM Namgu WHERE 세대수 <= 10000 AND 세대수 >= 5000;
SELECT * FROM Namgu WHERE 세대수 BETWEEN 5000 AND 10000;

SELECT * FROM Namgu WHERE 통 IN (21, 22, 23);
SELECT * FROM Namgu WHERE 통 NOT IN (21, 22, 23);

# Namgu 테이블에서
# 인구 수가 10000명 이상이면서 18세이상인구수 12000명 이하인 레코드 중 전체 필드 검색
SELECT * FROM Namgu WHERE 인구수 >= 10000 AND 18세이상인구수 <= 12000;

# Namgu 테이블에서
#통이 20이상이거나 반이 100 이하인 레코드 중 구분, 세대수, 인구 필드 검색
SELECT 구분, 세대수, 인구수 FROM Namgu WHERE 통 >= 20 OR 반 <= 100;

# Namgu 테이블에서
# 인구수가 10000명 이상인 레코드 중에서 18세이상인구수 12000명 이하이거나 반이 100이상인 레코드 중 전체 필드 검색
SELECT * FROM Namgu WHERE 인구수 >= 10000 AND (18세이상인구수 <= 12000 OR 반 >= 100);

SELECT * FROM Namgu WHERE 인구수 >= 10000 AND 18세이상인구수 <= 12000 OR 반 >= 100;

SELECT count(면적), max(세대수), min(세대수)
FROM Namgu
WHERE 면적 = 1;

SELECT 면적, count(*), max(세대수), min(세대수)
FROM Namgu
GROUP BY 면적; #면적을 그룹지어서 각 면적별 필드 수, 최대 세대수, 최소 세대수를 보여줌

# GROUP BY에 적용되지 않은 필드는 HAVING에 사용할 수 없다
SELECT 면적, count(*), max(세대수), min(세대수)
FROM Namgu
GROUP BY 면적
HAVING max(세대수) >= 5000 
ORDER BY 면적;