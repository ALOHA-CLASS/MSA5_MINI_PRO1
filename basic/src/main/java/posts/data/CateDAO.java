package posts.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.jdbc.JDBConnection;
import posts.model.Category;



/**
 *  데이터 접근 객체
 *  - 카테고리 데이터 접근
 */
public class CateDAO extends JDBConnection {
	
	// 데이터 목록
	public List<Category> list() {
		
		List<Category> categoryList = new ArrayList<Category>();
		
		String sql = " SELECT * "
				   + " FROM category ";
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {		// next() : 실행 결과의 다음 데이터로 이동
				Category category = new Category();
				
				category.setId( rs.getString("id") );
				category.setCategoryId( rs.getString("category_id") );
				category.setName( rs.getString("name") );
				category.setPostNo( rs.getInt("post_no") );
				category.setType( rs.getString("type") );
				category.setRegDate( rs.getTimestamp("reg_date") );
				category.setUpdDate( rs.getTimestamp("upd_date") );
				
				categoryList.add(category);
			}
		} catch(SQLException e) {
			System.err.println("카테고리 목록 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return categoryList;
	}
	
	// 데이터 조회
	public Category select(String id) {
		Category category = new Category();
		
		String sql = " SELECT * "
				   + " FROM category "
				   + " WHERE id = ? ";
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString( 1, id );	
			rs = psmt.executeQuery();
			
			if( rs.next() ) {		// next() : 실행 결과의 다음 데이터로 이동
				category.setId( rs.getString("id") );
				category.setCategoryId( rs.getString("category_id") );
				category.setName( rs.getString("name") );
				category.setPostNo( rs.getInt("post_no") );
				category.setType( rs.getString("type") );
				category.setRegDate( rs.getTimestamp("reg_date") );
				category.setUpdDate( rs.getTimestamp("upd_date") );
			}
		} catch(SQLException e) {
			System.err.println("카테고리 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return category;
	}
	
	
	// 데이터 등록
	public int insert(Category category) {
		int result = 0;		// 결과 : 적용된 데이터 건수
		
		String sql = " INSERT INTO category (id, category_id, name, post_no, type) "
				   + " VALUES(RAWTOHEX(SYS_GUID()), ?, ?, ?, ? ) ";
		
		try {
			psmt = con.prepareStatement(sql);			
			psmt.setString( 1, category.getCategoryId() );
			psmt.setString( 2, category.getName() );	
			psmt.setInt( 3, category.getPostNo() );	
			psmt.setString( 4, category.getType() );	
			
			result = psmt.executeUpdate();		
		} catch (SQLException e) {
			System.err.println("카테고리 등록 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	// 데이터 수정
	public int update(Category category) {
		int result = 0;		
		
		String sql = " UPDATE category "
				   + " SET category_id  = ? "
				   + "    ,name = ? "
				   + "    ,post_no = ? "
				   + "    ,type = ? "
				   + "	  ,upd_date = sysdate "
				   + " WHERE id = ? ";
		
		try {
			psmt = con.prepareStatement(sql);			
			psmt.setString( 1, category.getCategoryId() );	
			psmt.setString( 2, category.getName() );	
			psmt.setInt( 3, category.getPostNo() );	
			psmt.setString( 4, category.getType() );
			psmt.setString(5, category.getId() );
			
			result = psmt.executeUpdate();		// SQL 실행 요청, 적용된 데이터 개수를 받아온다.
		} catch (SQLException e) {
			System.err.println("카테고리 수정 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	// 데이터 삭제
	public int delete(String id) {
		int result = 0;		
		
		String sql = " DELETE FROM category "
				   + " WHERE id = ? ";
		
		try {
			psmt = con.prepareStatement(sql);	
			psmt.setString( 1, id );				
			
			result = psmt.executeUpdate();		
		} catch (SQLException e) {
			System.err.println("카테고리 삭제 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	
	
	// 데이터 조회
	public Category selectByCategoryId(String categoryId) {
		Category category = new Category();
		
		String sql = " SELECT * "
				   + " FROM category "
				   + " WHERE category_id = ? ";
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString( 1, categoryId );	
			rs = psmt.executeQuery();
			
			if( rs.next() ) {		
				System.out.println("조회됨...");
				category.setId( rs.getString("id") );
				category.setCategoryId( rs.getString("category_id") );
				category.setName( rs.getString("name") );
				category.setPostNo( rs.getInt("post_no") );
				category.setType( rs.getString("type") );
				category.setRegDate( rs.getTimestamp("reg_date") );
				category.setUpdDate( rs.getTimestamp("upd_date") );
			}
		} catch(SQLException e) {
			System.err.println("카테고리 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return category;
	}

}


























