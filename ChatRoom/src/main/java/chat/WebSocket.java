package chat;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatting/{roomName}") // 웹 소켓 엔드포인트 URL 설정 + 경로 파라미터 추가
public class WebSocket {

	
	/**
	 * // 클라이언트가 웹 소켓에 연결될 때 호출되는 메소드
	 * @param session
	 */
	@OnOpen
    public void onOpen(Session session, @PathParam("roomName") String roomName) {
		// 최초 채팅방 생성
		ChatRoomManager.createChatRoom(roomName);
		// 채팅방 참가
		ChatRoomManager.joinChatRoom(roomName, session);
		session.getAsyncRemote().sendText(roomName + "의 채팅방에 접속하였습니다.");
    }

    
	/**
	 * 클라이언트로부터 메시지를 받았을 때 호출되는 메소드
	 * @param message   - 수신 메시지
	 * @param session
	 * @param roomName  - 채팅방 이름
	 */
	@OnMessage
    public void onMessage(String message, Session session, @PathParam("roomName") String roomName) {
		ChatRoom chatRoom = ChatRoomManager.getInstance().getChatRoom(roomName);
        if (chatRoom != null) {
            // 채팅방에 참여한 모든 세션에게 메시지 전송
            for (Session participant : chatRoom.getSessions()) {
                if (participant.isOpen()) {
                    try {
                        participant.getBasicRemote().sendText(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 클라이언트와의 연결이 닫힐 때 호출되는 메소드
     * @param session
     */
	@OnClose
    public void onClose(Session session, @PathParam("roomName") String roomName) {
        ChatRoomManager.leaveChatRoom(roomName, session);
    }
}



