-- TB_TODO 테이블 생성

CREATE TABLE TB_TODO (	
	TODO_NO	NUMBER CONSTRAINT TB_TODO_PK PRIMARY KEY,
	TODO_TITLE VARCHAR2(50) NOT NULL,
	TODO_CONTENT VARCHAR2(4000) NOT NULL,
	COMPLETE CHAR(1) DEFAULT 'N'
		CONSTRAINT COMPLETE_YN CHECK(COMPLETE IN ('Y', 'N') ),
	REG_DATE DATE DEFAULT SYSDATE
);

COMMENT ON COLUMN TB_TODO.TODO_NO 			IS '할 일 번호';
COMMENT ON COLUMN TB_TODO.TODO_TITLE  	IS '할 일 제목';
COMMENT ON COLUMN TB_TODO.TODO_CONTENT 	IS '할 일 내용';
COMMENT ON COLUMN TB_TODO.COMPLETE 			IS '할 일 완료 여부(Y/N)';
COMMENT ON COLUMN TB_TODO.REG_DATE 			IS '할 일 등록일';

-- 할 일 번호(TODO_NO) 번호 생성기(SEQUENCE) 만들기
CREATE SEQUENCE SEQ_TODO_NO NOCACHE;

INSERT INTO TB_TODO VALUES (SEQ_TODO_NO.NEXTVAL, '테스트 제목1', '테스트 내용1', DEFAULT, DEFAULT);
INSERT INTO TB_TODO VALUES (SEQ_TODO_NO.NEXTVAL, '테스트 제목2', '테스트 내용2', DEFAULT, DEFAULT);
INSERT INTO TB_TODO VALUES (SEQ_TODO_NO.NEXTVAL, '테스트 제목3', '테스트 내용3', DEFAULT, DEFAULT);

SELECT * FROM TB_TODO;

COMMIT;

-- 할 일 목록 조회
SELECT TODO_NO, TODO_TITLE, COMPLETE, TO_CHAR(REG_DATE, 'YYYY-MM-DD HH24:MI:SS') "REG_DATE"
FROM TB_TODO
ORDER BY TODO_NO;


-- 특정 할 일 1개 상세 조회
SELECT TODO_NO, TODO_TITLE, TODO_CONTENT  , COMPLETE, TO_CHAR(REG_DATE, 'YYYY-MM-DD HH24:MI:SS') "REG_DATE"
FROM TB_TODO
WHERE TODO_NO = 1;


-- 완료된 할 일 개수 조회
SELECT COUNT(*)
FROM TB_TODO 
WHERE COMPLETE ='Y';
