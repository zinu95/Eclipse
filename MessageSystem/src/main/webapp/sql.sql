1. 회원가입한 정보를 저장할 수 있는 'web_member'테이블을 만드시오.
   컬럼명 : m_email / m_pw / m_tel / m_address

select * from web_member;

-- 메시지 번호(시퀀스), 보내는 사람, 받는 사람, 메시지 내용, 메시지 보낸 시간(시스템 시간)
create table web_message(
	num number(10),
	sendName varchar2(100),
	receiverEmail varchar2(100),
	message varchar2(500),
	m_date date
)



create sequence num_message
increment by 1 -- 1씩 증가
start with 1 -- 시작 숫자(1부터 시작)
minvalue 1 -- 최소값(1)
maxvalue 100 -- 최대값(100)
nocycle; -- 최대값 도달시 다시 시작할 것인지?







