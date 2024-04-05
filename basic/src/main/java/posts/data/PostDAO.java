package posts.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.jdbc.JDBConnection;
import posts.model.Posts;


// TODO: Board -> Post 로 변경하기


/**
 *  데이터 접근 객체
 *  - 게시글 데이터 접근
 */
public class PostDAO extends JDBConnection {
	
	// 데이터 목록
	public List<Posts> list() {
		
		List<Posts> postList = new ArrayList<Posts>();
		
		String sql = " SELECT * "
				   + " FROM posts ";
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {		
				Posts post = new Posts();
				
				post.setId( rs.getString("id") );
				post.setUsersId( rs.getString("users_id") );
				post.setCateId( rs.getString("cate_id") );
				post.setPostNo( rs.getInt("post_no") );
				post.setTitle( rs.getString("title") );
				post.setUsername( rs.getString("username") );
				post.setName( rs.getString("name") );
				post.setContent( rs.getString("password") );
				post.setContent( rs.getString("content") );
				post.setRegDate( rs.getTimestamp("reg_date") );
				post.setUpdDate( rs.getTimestamp("upd_date") );
				
				postList.add(post);
			}
		} catch(SQLException e) {
			System.err.println("게시글 목록 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return postList;
	}
	
	// 데이터 조회
	public Posts select(String id) {
		Posts post = new Posts();
		
		String sql = " SELECT * "
				   + " FROM posts "
				   + " WHERE id = ? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString( 1, id );		
			rs = psmt.executeQuery();
			
			if( rs.next() ) {
				post.setId( rs.getString("id") );
				post.setUsersId( rs.getString("users_id") );
				post.setCateId( rs.getString("cate_id") );
				post.setPostNo( rs.getInt("post_no") );
				post.setTitle( rs.getString("title") );
				post.setUsername( rs.getString("username") );
				post.setName( rs.getString("name") );
				post.setContent( rs.getString("password") );
				post.setContent( rs.getString("content") );
				post.setRegDate( rs.getTimestamp("reg_date") );
				post.setUpdDate( rs.getTimestamp("upd_date") );
				
			}
		} catch(SQLException e) {
			System.err.println("게시글 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return post;
	}
	
	
	// 데이터 등록
	public int insert(Posts post) {
		int result = 0;		
		
		String sql = " INSERT INTO posts (id, users_id, cate_id, post_no, title, username, name, password, content ) "
				   + " VALUES( ? , ?, ?, ?, ?, ?, ?, ?, ? ) ";
		
		try {
			psmt = con.prepareStatement(sql);		
			psmt.setString( 1, post.getId() );	
			psmt.setString( 2, post.getUsersId() );	
			psmt.setString( 3, post.getCateId() );
			psmt.setInt( 4, post.getPostNo() );
			psmt.setString( 5, post.getTitle());
			psmt.setString( 6, post.getUsername());
			psmt.setString( 7, post.getName());
			psmt.setString( 8, post.getPassword());
			psmt.setString( 9, post.getContent());
			
			result = psmt.executeUpdate();		
		} catch (SQLException e) {
			System.err.println("게시글 등록 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	// 데이터 수정
	public int update(Posts post) {
		int result = 0;		
		
		String sql = " UPDATE posts "
				   + " SET title = ? "
				   + "    ,user_id  = ? "
				   + "    ,content = ? "
				   + "	  ,upd_date = sysdate "
				   + " WHERE id = ? ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString( 1, post.getTitle() );	
			psmt.setString( 2, post.getUsername() );
			psmt.setString( 3, post.getContent() );
			psmt.setString( 4, post.getId() );	
			
			result = psmt.executeUpdate();		
		} catch (SQLException e) {
			System.err.println("게시글 수정 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	// 데이터 삭제
	public int delete(String id) {
		int result = 0;		// 결과 : 적용된 데이터 건수
		
		String sql = " DELETE FROM posts "
				   + " WHERE id = ? ";
		
		try {
			psmt = con.prepareStatement(sql);	
			psmt.setString( 1, id );				
			
			result = psmt.executeUpdate();		
		} catch (SQLException e) {
			System.err.println("게시글 삭제 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 카테고리id 기준으로 게시글 목록 조회
	 * - 카테고리별 게시판
	 * @param cateId
	 * @return
	 */
	public List<Posts> listByCateId(String cateId) {
		List<Posts> postList = new ArrayList<Posts>();
		
		String sql = " SELECT * "
				   + " FROM posts"
				   + " WHERE cate_id = ? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, cateId);
			
			rs = psmt.executeQuery();
			
			while( rs.next() ) {		
				Posts post = new Posts();
				
				post.setId( rs.getString("id") );
				post.setUsersId( rs.getString("users_id") );
				post.setCateId( rs.getString("cate_id") );
				post.setPostNo( rs.getInt("post_no") );
				post.setTitle( rs.getString("title") );
				post.setUsername( rs.getString("username") );
				post.setName( rs.getString("name") );
				post.setContent( rs.getString("password") );
				post.setContent( rs.getString("content") );
				post.setRegDate( rs.getTimestamp("reg_date") );
				post.setUpdDate( rs.getTimestamp("upd_date") );
				
				postList.add(post);
			}
		} catch(SQLException e) {
			System.err.println("게시글 목록 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return postList;
	}

	
}


























