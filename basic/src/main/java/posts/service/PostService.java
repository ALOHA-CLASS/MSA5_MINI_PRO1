package posts.service;

import java.util.List;

import posts.model.Posts;


/**
 * 게시판 프로그램의 인터페이스
 * * 게시판의 기능 메소드
 * - 게시글 목록
 * - 게시글 조회
 * - 게시글 등록
 * - 게시글 수정
 * - 게시글 삭제
 * 
 */
public interface PostService {
	// 게시글 목록
	List<Posts> list();
	
	// 게시글 조회
	Posts select(String id);
	
	// 게시글 등록
	int insert(Posts posts);
	
	// 게시글 수정
	int update(Posts posts);
	
	// 게시글 삭제
	int delete(String id);
	
	// --------------------------------------
	
	// 게시글 목록
	List<Posts> listByCateId(String cateId);
}







