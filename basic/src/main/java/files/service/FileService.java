package files.service;

import java.util.List;

import files.dto.Files;


/**
 * 파일 인터페이스
 * * 파일의 기능 메소드
 * - 파일 목록
 * - 파일 조회
 * - 파일 등록
 * - 파일 수정
 * - 파일 삭제
 * 
 */
public interface FileService {
	// 파일 목록
	List<Files> list();
	
	// 파일 조회
	Files select(String no);
	
	// 파일 등록
	int insert(Files file);
	
	// 파일 수정
	int update(Files file);
	
	// 파일 삭제
	int delete(String no);
	
	// --------------------------------------------
	// 파일 목록 - parent
	List<Files> listByParent( Files file );
		
}







