package users.service;

import users.data.UserDAO;
import users.model.PersistentLogins;
import users.model.Users;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO = new UserDAO();
	
	@Override
	public int join(Users user) {
		int result = userDAO.join(user);
		
		if( result > 0 ) {
			System.out.println("회원 가입 처리 성공!");
		} else {
			System.out.println("회원 가입 실패!");
		}
		// 기본 회원 권한을 추가...
		
		return result;
	}
	
	
	@Override
	public boolean idCheck(String username) {

		boolean result = userDAO.idCheck(username);
		return result;
	}

	@Override
	public Users login(Users user) {
		
		Users loginUser = userDAO.login(user);
		
		// 로그인 성공
		if( loginUser != null ) {
			System.out.println("로그인 성공!");
			return loginUser;
		}
		
		// 로그인 실패
		System.out.println("로그인 실패!");
		return null;
	}

	@Override
	public String refreshToken(Users user) {
		
		PersistentLogins persistentLogins = userDAO.selectToken(user.getUsername());
		
		String token = null; 
		if( persistentLogins == null ) {
			// 토큰이 없는 경우, 토큰 등록
			token = userDAO.insertToken(user);
		}
		else {
			// 토큰이 없는 경우, 토큰 수정
			token = userDAO.updateToken(user.getUsername());
		}
		return token;
	}

	@Override
	public int deleteToken(String username) {
		int result = userDAO.deleteToken(username);
		if( result > 0 ) {
			System.out.println("자동 로그인 토큰 삭제 성공!");
		}
		else {
			System.out.println("자동 로그인 토큰 삭제 실패!");
		}
		return result;
	}

	@Override
	public PersistentLogins selectTokenByToken(String token) {
		
		PersistentLogins persistentLogins = userDAO.selectTokenByToken(token);
		
		if( persistentLogins == null ) {
			System.out.println("인증된 토큰 정보가 존재하지 않습니다.");
			return null;
		}
		else {
			System.out.println("인증된 토큰 확인됨...");
			return persistentLogins;
		}
	}

	

}













