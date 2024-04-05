package users.data;

import java.sql.SQLException;
import java.util.UUID;

import common.jdbc.JDBConnection;
import users.model.PersistentLogins;
import users.model.Users;


public class UserDAO extends JDBConnection {

	/**
     * 회원 가입
     * @param user 등록할 회원 정보
     * @return 등록된 데이터 개수
     */
    public int join(Users user) {
        int result = 0;

        String sql = "INSERT INTO users (id, username, password, name, email, reg_date, upd_date) " +
                     "VALUES (RAWTOHEX(SYS_GUID()), ?, ?, ?, ?, sysdate, sysdate)";

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, user.getUsername());
            psmt.setString(2, user.getPassword());
            psmt.setString(3, user.getName());
            psmt.setString(4, user.getEmail());

            result = psmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("회원 가입 중 오류 발생");
            e.printStackTrace();
        }

        return result;
    }
	
	
	/**
	 * 로그인
	 * @param user
	 * @return
	 */
	public Users login(Users user) {
		
		// SQL 작성
		String sql = " SELECT * "
				   + " FROM users "
				   + " WHERE username = ? and password = ? ";
		try {
			// 쿼리(SQL) 실행 객체 생성 - PreparedStatement (psmt)
			psmt = con.prepareStatement(sql);
			
			// psmt.setXXX( 순서번호, 매핑할 값 );
			psmt.setString( 1, user.getUsername() );
			psmt.setString( 2, user.getPassword() );
			
			// 쿼리(SQL) 실행 -> 결과  - ResultSet (rs)
			rs = psmt.executeQuery();
			
			// 조회 결과를 1건 가져오기
			if( rs.next() ) {		// next() : 실행 결과의 다음 데이터로 이동
				user.setId( rs.getString("id") );
				user.setUsername( rs.getString("username"));
				user.setPassword( rs.getString("password"));
				user.setName( rs.getString("name") );
				user.setEmail( rs.getString("email") );
				user.setRegDate( rs.getDate("reg_date") );
				user.setUpdDate( rs.getDate("upd_date") );
				return user;		// 로그인 성공
			}
			return null;
		} catch(SQLException e) {
			System.err.println("로그인 시, 예외 발생");
			e.printStackTrace();
		}
		return null;
	}

	/**
     * 토큰 생성 및 등록
     * @param userId 사용자 아이디
     * @return 생성된 토큰 값
     */
    public String insertToken(Users user) {
        int result = 0;
        String token = UUID.randomUUID().toString(); // UUID를 사용하여 토큰 생성

        String sql = " INSERT INTO persistent_logins (id, users_id, username, token, reg_date, upd_date) " +
                     " VALUES (RAWTOHEX(SYS_GUID()), ?, ?, ?, sysdate, sysdate) ";

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, user.getId()); // 사용자 아이디를 바이트 배열로 변환하여 사용
            psmt.setString(2, user.getUsername()); // 사용자 아이디에서 username 추출
            psmt.setString(3, token);

            result = psmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("자동 로그인 정보 등록 중, 에러 발생!");
            e.printStackTrace();
        }
        System.out.println("자동 로그인 정보 " + result + " 개 등록되었습니다.");
        return token;
    }

	/**
	 * 토큰 수정
	 * - 기존 토큰 존재 시, 갱신
	 * @param userId
	 * @return
	 */
	public String updateToken(String username) {
		int result = 0;
		String sql = " UPDATE persistent_logins"
				   + " SET token = ?"
				   + "    ,upd_date = sysdate"
				   + " WHERE username = ? ";
		// 토큰 발행
		String token = UUID.randomUUID().toString();
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, token);
			psmt.setString(2, username);
			
			result = psmt.executeUpdate();	
		} catch (SQLException e) {
			System.err.println("자동 로그인 정보 수정 중, 에러 발생!");
			e.printStackTrace();
		}
		System.out.println("자동 로그인 정보 " + result + " 개 수정되었습니다.");
		return token;
	}
	
	
	
	/**
	 * 토큰 조회 
	 * - userId 로 조회
	 * @param userId
	 * @return
	 */
	public PersistentLogins selectToken(String username) {
		String sql = " SELECT * "
				   + " FROM persistent_logins "
				   + " WHERE username = ? ";
		
		PersistentLogins persistentLogins = null;
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, username);
			
			rs = psmt.executeQuery();
			if( rs.next() ) {
				persistentLogins = new PersistentLogins();
				persistentLogins.setId( rs.getString("id") );
				persistentLogins.setUsersId( rs.getString("users_id") );
				persistentLogins.setUsername( rs.getString("username") );
				persistentLogins.setToken( rs.getString("token") );
				persistentLogins.setRegDate( rs.getDate("reg_date") );
				persistentLogins.setUpdDate( rs.getDate("upd_date") );
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("자동 로그인 정보 조회 중, 에러 발생!");
			e.printStackTrace();
		}
		return persistentLogins;
	}
	
	
	/**
	 * 토큰 조회 
	 * - token 으로 조회
	 * @param token
	 * @return
	 */
	public PersistentLogins selectTokenByToken(String token) {
		String sql = " SELECT * "
				   + " FROM persistent_logins "
				   + " WHERE token = ? ";
		
		PersistentLogins persistentLogins = null;
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, token);
			
			rs = psmt.executeQuery();
			if( rs.next() ) {
				persistentLogins = new PersistentLogins();
				persistentLogins.setId( rs.getString("id") );
				persistentLogins.setUsersId( rs.getString("users_id") );
				persistentLogins.setUsername( rs.getString("username") );
				persistentLogins.setToken( rs.getString("token") );
				persistentLogins.setRegDate( rs.getDate("reg_date") );
				persistentLogins.setUpdDate( rs.getDate("upd_date") );
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("자동 로그인 정보 조회 중, 에러 발생!");
			e.printStackTrace();
		}
		return persistentLogins;
	}
	
	/**
	 * 토큰 삭제
	 * - 로그아웃 시, 자동 로그인 해제
	 * @param userId
	 * @return
	 */
	public int deleteToken(String username) {
		int result = 0;
		String sql = " DELETE FROM persistent_logins WHERE username = ? ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, username);
			
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("자동 로그인 정보 삭제 중, 에러 발생!");
			e.printStackTrace();
		}
		System.out.println("자동 로그인 정보 " + result + " 개의 데이터가 삭제되었습니다.");
		return result;
	}
	
}



















