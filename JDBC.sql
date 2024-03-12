-- 급여를 300만 보다 많이 받는 사원의
-- 사번, 이름, 급여, 직급명 조회
SELECT EMP_ID, EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE SALARY >= 3000000
ORDER BY SALARY DESC;

SELECT EMP_ID, EMP_NAME, SALARY 
FROM EMPLOYEE
WHERE SALARY BETWEEN 1000000 AND 3000000
ORDER BY SALARY DESC;

SELECT EMP_ID, EMP_NAME, DEPT_TITLE , JOB_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
NATURAL JOIN JOB
WHERE DEPT_TITLE = '총무부'
ORDER BY JOB_CODE;



CREATE TABLE DEPARTMENT4 
AS SELECT * FROM DEPARTMENT;

-- DEPARTMENT4 테이블에
-- 'DO', '기획개발팀', 'L2' 삽입
INSERT INTO DEPARTMENT4
VALUES ('DO', '기획개발팀', 'L2'); 
--> 실행 결과로 삽입된 행의 개수 반환!!

SELECT * FROM DEPARTMENT4;

-- 사용자(개발자)가 직접 트랜잭션 제어 처리
COMMIT;
ROLLBACK;

-- 부서 검색
SELECT * FROM DEPARTMENT4
WHERE DEPT_TITLE LIKE '%' || '영' || '%';


-- 부서 삭제
DELETE FROM DEPARTMENT4 
WHERE DEPT_ID = '해외영업2부';

UPDATE DEPARTMENT4 SET DEPT_TITLE
WHERE DEPT_ID ;;


-- 부서 코드가 일치하는 부서가 있는지 확인
SELECT COUNT(*)  FROM DEPARTMENT4
WHERE DEPT_ID =







