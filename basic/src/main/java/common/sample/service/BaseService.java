package common.sample.service;

import java.util.List;

import common.sample.dto.Base;


/**
 * 기본 인터페이스
 * * 기본의 기능 메소드
 * - 기본 목록
 * - 기본 조회
 * - 기본 등록
 * - 기본 수정
 * - 기본 삭제
 * 
 */
public interface BaseService {
	// 기본 목록
	List<Base> list();
	
	// 기본 조회
	Base select(String no);
	
	// 기본 등록
	int insert(Base base);
	
	// 기본 수정
	int update(Base base);
	
	// 기본 삭제
	int delete(String no);
}







