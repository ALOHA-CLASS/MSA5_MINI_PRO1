package posts.service;

import java.util.List;
import java.util.UUID;

import files.dto.Files;
import files.service.FileService;
import files.service.FileServiceImpl;
import posts.data.CateDAO;
import posts.data.PostDAO;
import posts.model.Category;
import posts.model.Posts;





/**
 * 게시판 기능 - 비즈니스 로직 클래스
 */
public class PostServiceImpl implements PostService {
	
	private PostDAO postDAO = new PostDAO();
	private FileService fileService = new FileServiceImpl();

	@Override
	public List<Posts> list() {
		
		List<Posts> postList = postDAO.list();
		
		// 파일 세팅 
		postList = setFileList(postList);
		return postList;
	}

	@Override
	public Posts select(String id) {
		// 1. 게시글 번호에 대한 게시글 정보 데이터 요청
		Posts post = postDAO.select(id);
		
		// 2. 게시글 정보 반환
		return post;
	}

	@Override
	public int insert(Posts post) {
		
		// posts 의 새 id 생성
		String uid = UUID.randomUUID().toString();
		post.setId(uid);
		
		// 1. category 에서 postNo 가져오기
		CateDAO cateDAO = new CateDAO();
		Category category = cateDAO.select(post.getCateId());
		int postNo = category.getPostNo();
		post.setPostNo(postNo);
		
		// 2. 게시글 정보를 전달하여 게시글 데이터 등록 요청
		int result = postDAO.insert(post);
		
		// 3. 데이터 등록 성공 시,
		if( result > 0 ) {
			// System.out.println("글쓰기 성공 : " + post.getId());
			// - DB에 category 의 postNo + 1
			category.setPostNo(postNo + 1);
			cateDAO.update(category);
			
			// - 파일 업로드
			List<Files> fileList = post.getFileList();
			if( fileList != null ) {
				for (Files file : fileList) {
					// 해당 파일의 부모 테이블 	- parentName 	: "posts" 
					// 해당 파일의 부모 ID(PK) 	- parentId		: uid
					file.setParentName("posts");
					file.setParentId(uid);
					
					// 파일 등록 요청
					fileService.insert(file);
					
				}
			}
			
		}
		
		return result;
	}

	@Override
	public int update(Posts post) {
		// 1. 게시글 정보를 전달하여 게시글 데이터 수정 요청
		int result = postDAO.update(post);
		// 2. 적용된 데이터 건수를 반환
		//   - 결과 : 0 --> 데이터 수정 실패
		//           1 --> 데이터 수정 성공
		return result;
	}

	@Override
	public int delete(String id) {
		// 1. 게시글 번호를 전달하여 게시글 데이터 삭제 요청
		int result = postDAO.delete(id);
		// 2. 적용된 데이터 건수를 반환
		//   - 결과 : 0 --> 데이터 삭제 실패
		//           1 --> 데이터 삭제 성공
		return result;
	}

	@Override
	public List<Posts> listByCateId(String cateId) {
		List<Posts> postList = postDAO.listByCateId(cateId);
		
		// 파일 세팅
		postList = setFileList(postList);
		return postList;
	}
	
	
	// TODO : SQL 에서 조인으로 시도해보기 나중에
	/**
	 * 게시글 목록에 파일 
	 * @param list
	 * @return
	 */
	public List<Posts> setFileList(List<Posts> list) {
		Files file = new Files();
		
		if( list != null )
		for (Posts posts : list) {
			file.setParentName("posts");
			file.setParentId( posts.getId() );
			List<Files> fileList = fileService.listByParent( file );
			
			if( fileList.isEmpty() ) System.out.println("해당 게시글을 파일이 없습니다. : " + posts.getId()); 
			posts.setFileList(fileList);
			
			// 썸네일 파일 아이디 등록
			for (Files f : fileList) {
				System.out.println("파일 : " + f.getFileName());
				if( f.getType() != null && f.getType().equals("thumbnail") ) {
					System.out.println("썸네일이 있어요 : " + f.getFileName());
					posts.setThumbnailFileId(f.getId());
				}
			}
		}
		return list;
	}

}













