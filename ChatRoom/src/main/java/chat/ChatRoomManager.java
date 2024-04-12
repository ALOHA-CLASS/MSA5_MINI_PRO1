package chat;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

public class ChatRoomManager {
	private static ChatRoomManager instance;
    private static Map<String, ChatRoom> chatRooms = new HashMap<>();
    
    private ChatRoomManager() {
        chatRooms = new HashMap<>();
    }

    public static ChatRoomManager getInstance() {
        if (instance == null) {
        	instance = new ChatRoomManager();
        }
        return instance;
    }

    public static void createChatRoom(String name) {
    	if( chatRooms.get(name) != null ) return;
        ChatRoom chatRoom = new ChatRoom(name);
        chatRooms.put(name, chatRoom);
        System.out.println("새로운 채팅방 개설 : " + name);
    }

    public static void joinChatRoom(String roomName, Session session) {
        ChatRoom chatRoom = chatRooms.get(roomName);
        if (chatRoom != null) {
        	System.out.println("채팅방에 새 세션 추가 : " + session.getId());
            chatRoom.addSession(session);
        }
    }

    public static void leaveChatRoom(String roomName, Session session) {
        ChatRoom chatRoom = chatRooms.get(roomName);
        if (chatRoom != null) {
            chatRoom.removeSession(session);
        }
    }
    
    public ChatRoom getChatRoom(String roomName) {
        return chatRooms.get(roomName);
    }
}
