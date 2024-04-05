package posts.service;

import java.util.List;

import posts.model.Category;


/**
 * 카테고리 인터페이스
 * * 카테고리의 기능 메소드
 * - 카테고리 목록
 * - 카테고리 조회
 * - 카테고리 등록
 * - 카테고리 수정
 * - 카테고리 삭제
 * 
 */
public interface CateService {
	// 카테고리 목록
	List<Category> list();
	
	// 카테고리 조회
	Category select(String id);
	
	// 카테고리 등록
	int insert(Category category);
	
	// 카테고리 수정
	int update(Category category);
	
	// 카테고리 삭제
	int delete(String id);
	
	// ------------------------------------
	
	// 카테고리 조회 - categoryId
	Category selectByCategoryId(String id);
}







