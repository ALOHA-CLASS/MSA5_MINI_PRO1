-- ALOHA이 있을 때, 계정 잠금 해제
ALTER USER aloha ACCOUNT UNLOCK;

-- ALOHA이 없을 때, 계정 생성
-- c## 없이 계정 생성
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
-- CREATE USER 계정명 IDENTIFIED BY 비밀번호;
CREATE USER aloha IDENTIFIED BY 123456;
-- 테이블 스페이스 변경
ALTER USER aloha DEFAULT TABLESPACE users;
-- 계정이 사용할 수 있는 용량 설정 (무한대)
ALTER USER aloha QUOTA UNLIMITED ON users;
-- 계정에 권한 부여 
GRANT connect, resource TO aloha;