
-- 아직 테이블이 만들어지지 않았기 때문에 실행하면 오류가 뜬다.
DROP TABLE TB_MEMBER;
DROP SEQUENCE MEMBERSEQ;

-- 1. SEQUNCE 생성. 먼저 이것을 드래그 한 뒤 실행(run)한다.
CREATE SEQUENCE MEMBERSEQ;


-- 2. 번호, 이름, 나이, 성별, 지역, 하는 일, 전화번호, 이메일이 들어갈 colum을 만든다.
CREATE TABLE TB_MEMBER(
	M_NO NUMBER PRIMARY KEY,
	M_NAME VARCHAR2(20) NOT NULL,
	M_AGE NUMBER NOT NULL,
	M_GENDER VARCHAR(2) CHECK(M_GENDER IN ('M', 'F')) NOT NULL,
	M_LOCATION VARCHAR2(50),
	M_JOB VARCHAR2(20),
	M_TEL VARCHAR2(20),
	M_EMAIL VARCHAR2(20)
);

-- 3. row를 생성한다. -- 번호 자동으로 올라가게 하려고 시퀀스를 만들어 놓았다. // gender에 대문자 'M', 'F'만 들어가게 설정하였기 때문에 만약 사용자가 그것을 몰라서 소문자로 적었다면 바꿔줘야 한다.
INSERT INTO TB_MEMBER 
VALUES (MEMBERSEQ.NEXTVAL, '관리자', 100, 'M', '수원', '건물관리자', '010-1111-1111', 'ADMIN@ADMIN.COM');

-- 4. 테이블을 출력한다.
SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL
FROM TB_MEMBER;

SELECT MEMBERSEQ.NEXTVAL, MEMBERSEQ.CERRVAL FROM DUAL;