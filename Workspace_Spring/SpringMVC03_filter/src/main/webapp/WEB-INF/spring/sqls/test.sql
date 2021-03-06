
DROP SEQUENCE MYNOSEQ;

DROP SEQUENCE GROUPNOSEQ;

DROP TABLE MYBOARD;


CREATE SEQUENCE MYNOSEQ;

CREATE SEQUENCE GROUPNOSEQ:


CREATE TABLE MYBOARD(
	MYNO NUMBER NOT NULL,
	GROUPNO NUMBER NOT NULL,
	GROUPSEQ NUMBER NOT NULL,
	TITLETAB NUMBER NOT NULL,
	DELFLAG VARCHAR2(2) NOT NULL,
	MYNAME VARCHAR2(1000) NOT NULL,
	MYTITLE VARCHAR2(2000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL,
	VIEWCNT INT DEFAULT 0,
	CONSTRAINT ANSWER_MYNO_PK PRIMARY KEY (MYNO),
	CONSTRAINT ANSWER_DELFLAG_CK CHECK(DELFLAG IN ('Y', 'N'))
);


INSERT INTO MYBOARD
VALUES(MYNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0, 'N', '관리자', '스프링 재밌다.', '정말 재밌다.', SYSDATE, 0);


SELECT MYNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG, MYNAME, MYTITLE, MYCONTENT, MYDATE, VIEWCNT
FROM MYBOARD 
ORDER BY MYNO DESC, GROUPSEQ;


UPDATE MYBOARD
SET GROUPSEQ = GROUPSEQ + 1
WHERE GROUPNO = (SELECT GROUPNO FROM MYBOARD WHERE MYNO = 1)
AND GROUPSEQ > (SELECT GROUPSEQ FROM MYBOARD WHERE MYNO = 1);


INSERT INTO MYBOARD
VALUES(
		MYNOSEQ.NEXTVAL,
		(SELECT GROUPNO FROM MYBOARD WHERE MYNO = 1),
		(SELECT GROUPSEQ FROM MYBOARD WHERE MYNO = 1) + 1,
		(SELECT TITLETAB + 1 FROM MYBOARD MYNO = 1),
		'N',
		'RE:답변형재밌다.',
		'진짜 재밌는 거 맞아?',
		'강사',
		SYSDATE,
		0
);


UPDATE MYBOARD
SET DELFLAG = 'Y'
WHERE MYNO = 1;


SELECT MYNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG, MYNAME, MYTITLE, MYCONTENT, MYDATE, VIEWCNT
	FROM (
		SELECT MYNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG, MYNAME, MYTITLE, MYCONTENT, MYDATE, VIEWCNT, ROW_NUMBER() OVER(ORDER BY MYNO DESC) AS RNUM
		FROM MYBOARD
		) mb
	WHERE RNUM BETWEEN 1 AND 10
		ORDER BY MYNO DESC, GROUPSEQ LIMIT 10;
		
		