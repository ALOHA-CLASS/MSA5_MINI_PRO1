package common.sample.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.jdbc.JDBConnection;
import common.sample.dto.Base;

public class BaseDAO extends JDBConnection {

	// 데이터 목록
	public List<Base> list() {
		
		List<Base> fileList = new ArrayList<Base>();
		
		String sql = " SELECT * "
				   + " FROM base ";
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {		
				Base base = new Base();
				
				base.setId( rs.getString("id") );
				// 추가하기
				
				fileList.add(base);
			}
		} catch(SQLException e) {
			System.err.println("기본 목록 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return fileList;
	}
	
	// 데이터 조회
	public Base select(String id) {
		Base base = new Base();
		
		String sql = " SELECT * "
				   + " FROM base "
				   + " WHERE id = ? ";
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString( 1, id );	
			rs = psmt.executeQuery();
			
			if( rs.next() ) {		
				System.out.println("조회됨...");
				base.setId( rs.getString("id") );
				// 추가하기
			}
		} catch(SQLException e) {
			System.err.println("기본 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return base;
	}
	
	
	// 데이터 등록
	public int insert(Base base) {
		int result = 0;		
		
		String sql = " INSERT INTO base (id, 추가하기 ) "
				   + " VALUES(RAWTOHEX(SYS_GUID()), 추가하기 ) ";
		
		try {
			psmt = con.prepareStatement(sql);			
			psmt.setString( 1, "추가하기" );	
			
			result = psmt.executeUpdate();		
		} catch (SQLException e) {
			System.err.println("기본 등록 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	// 데이터 수정
	public int update(Base base) {
		int result = 0;		
		
		String sql = " UPDATE base "
				   + " SET 추가하기  = ? "
				   + "	  ,upd_date = sysdate "
				   + " WHERE id = ? ";
		
		try {
			psmt = con.prepareStatement(sql);			
			psmt.setString( 1, "추가하기" );
			psmt.setString( 2, base.getId() );
			
			result = psmt.executeUpdate();	
		} catch (SQLException e) {
			System.err.println("기본 수정 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	// 데이터 삭제
	public int delete(String id) {
		int result = 0;		
		
		String sql = " DELETE FROM base "
				   + " WHERE id = ? ";
		
		try {
			psmt = con.prepareStatement(sql);	
			psmt.setString( 1, id );				
			
			result = psmt.executeUpdate();		
		} catch (SQLException e) {
			System.err.println("기본 삭제 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

}
