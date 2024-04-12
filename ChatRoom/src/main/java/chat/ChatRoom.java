package chat;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

public class ChatRoom {
    private String name;
    private List<Session> sessions; // 채팅방에 참가한 세션 목록
    
	public ChatRoom() {
		
	}

	public ChatRoom(String name) {
		this.name = name;
		this.sessions = new ArrayList<Session>();
	}

	public ChatRoom(String name, List<Session> sessions) {
		this.name = name;
		this.sessions = sessions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

	@Override
	public String toString() {
		return "ChatRoom [name=" + name + ", sessions=" + sessions + "]";
	}
    
}
