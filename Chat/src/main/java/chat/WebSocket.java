package chat;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatting") // 웹 소켓 엔드포인트 URL 설정
public class WebSocket {

	/**
	 * // 클라이언트가 웹 소켓에 연결될 때 호출되는 메소드
	 * @param session
	 */
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket OPEN: " + session.getId());
    }

    /**
     * 클라이언트로부터 메시지를 받았을 때 호출되는 메소드
     * @param message	- 수신 메시지
     * @param session	-
     */
    @OnMessage
    public void onMessage(String message, Session session) {
    	// 해당 세션의 모든 클라이언트에 수신된 메시지 발송
        session.getAsyncRemote().sendText(message);
    }

    /**
     * 클라이언트와의 연결이 닫힐 때 호출되는 메소드
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
        System.out.println("WebSocket CLOSED: " + session.getId());
    }
}



