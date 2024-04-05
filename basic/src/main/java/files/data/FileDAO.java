package files.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.jdbc.JDBConnection;
import files.dto.Files;

public class FileDAO extends JDBConnection {

	// 데이터 목록
	public List<Files> list() {
		
		List<Files> fileList = new ArrayList<Files>();
		
		String sql = " SELECT * "
				   + " FROM files ";
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {		
				Files files = new Files();
				
				files.setId( rs.getString("id") );
				files.setParentName( rs.getString("parent_name") );
				files.setParentId( rs.getString("parent_id") );
				files.setType( rs.getString("type") );
				files.setFileName( rs.getString("file_name") );
				files.setFilePath( rs.getString("file_path") );
				files.setFileSize( rs.getLong("file_size") );
				files.setRegDate( rs.getTimestamp("reg_date") );
				files.setUpdDate( rs.getTimestamp("upd_date") );
				
				fileList.add(files);
			}
		} catch(SQLException e) {
			System.err.println("파일 목록 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return fileList;
	}
	
	// 데이터 조회
	public Files select(String id) {
		Files files = new Files();
		
		String sql = " SELECT * "
				   + " FROM files "
				   + " WHERE id = ? ";
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString( 1, id );	
			rs = psmt.executeQuery();
			
			if( rs.next() ) {		
				files.setId( rs.getString("id") );
				files.setParentName( rs.getString("parent_name") );
				files.setParentId( rs.getString("parent_id") );
				files.setType( rs.getString("type") );
				files.setFileName( rs.getString("file_name") );
				files.setFilePath( rs.getString("file_path") );
				files.setFileSize( rs.getLong("file_size") );
				files.setRegDate( rs.getTimestamp("reg_date") );
				files.setUpdDate( rs.getTimestamp("upd_date") );
			}
		} catch(SQLException e) {
			System.err.println("파일 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return files;
	}
	
	
	// 데이터 등록
	public int insert(Files files) {
		int result = 0;		
		
		String sql = " INSERT INTO files (id, parent_name, parent_id, type, file_name, file_path, file_size ) "
				   + " VALUES(RAWTOHEX(SYS_GUID()), ?, ?, ?, ?, ?, ? ) ";
		
		try {
			psmt = con.prepareStatement(sql);			
			psmt.setString( 1, files.getParentName() );	
			psmt.setString( 2, files.getParentId() );	
			psmt.setString( 3, files.getType() );	
			psmt.setString( 4, files.getFileName() );	
			psmt.setString( 5, files.getFilePath() );	
			psmt.setLong( 6, files.getFileSize() );	
			
			result = psmt.executeUpdate();		
		} catch (SQLException e) {
			System.err.println("파일 등록 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	// 데이터 수정
	public int update(Files files) {
		int result = 0;		
		
		String sql = " UPDATE files "
				   + " SET parent_name = ? "
				   + " 	  ,parent_id = ? "
				   + " 	  ,type = ? "
				   + " 	  ,file_name = ? "
				   + " 	  ,file_path = ? "
				   + " 	  ,file_size = ? "
				   + "	  ,upd_date = sysdate "
				   + " WHERE id = ? ";
		
		try {
			psmt = con.prepareStatement(sql);			
			psmt.setString( 1, files.getParentName() );
			psmt.setString( 2, files.getParentId() );
			psmt.setString( 3, files.getType() );
			psmt.setString( 4, files.getFileName() );
			psmt.setString( 5, files.getFilePath() );
			psmt.setLong( 6, files.getFileSize() );
			
			result = psmt.executeUpdate();		
		} catch (SQLException e) {
			System.err.println("파일 수정 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	// 데이터 삭제
	public int delete(String id) {
		int result = 0;		
		
		String sql = " DELETE FROM files "
				   + " WHERE id = ? ";
		
		try {
			psmt = con.prepareStatement(sql);	
			psmt.setString( 1, id );				
			
			result = psmt.executeUpdate();		
		} catch (SQLException e) {
			System.err.println("파일 삭제 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	// 파일 목록 - 부모 테이블의 파일 목록
	public List<Files> listByParent(Files file) {
		List<Files> fileList = new ArrayList<Files>();
		
		System.out.println("parentName : " + file.getParentName());
		System.out.println("parentId : " + file.getParentId());
		
		String sql = " SELECT * "
				   + " FROM files"
				   + " WHERE parent_name = ?"
				   + "   AND parent_id = ? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString( 1, file.getParentName() );	
			psmt.setString( 2, file.getParentId() );	
			rs = psmt.executeQuery();
			
			while( rs.next() ) {		
				Files files = new Files();
				
				files.setId( rs.getString("id") );
				files.setParentName( rs.getString("parent_name") );
				files.setParentId( rs.getString("parent_id") );
				files.setType( rs.getString("type") );
				files.setFileName( rs.getString("file_name") );
				files.setFilePath( rs.getString("file_path") );
				files.setFileSize( rs.getLong("file_size") );
				files.setRegDate( rs.getTimestamp("reg_date") );
				files.setUpdDate( rs.getTimestamp("upd_date") );
				
				fileList.add(files);
			}
		} catch(SQLException e) {
			System.err.println("파일 목록 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return fileList;
	}

}

















