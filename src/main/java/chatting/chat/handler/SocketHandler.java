package chatting.chat.handler;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;

@Component
public class SocketHandler extends TextWebSocketHandler {
    HashMap<String, WebSocketSession> sessionMap = new HashMap<>(); //웹소켓 세션을 담아둘 맵
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //connect socket
        super.afterConnectionEstablished(session);
        sessionMap.put(session.getId(), session);
        JSONObject obj = new JSONObject();
        obj.put("type","getId");
        obj.put("sessionId",session.getId());
        session.sendMessage(new TextMessage(obj.toJSONString()));

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //메시지 연결
        String msg = message.getPayload();
        JSONObject obj = JsonToObjectParser(msg);
        for (String key :sessionMap.keySet()) {
            WebSocketSession wss = sessionMap.get(key);
            try {
                wss.sendMessage(new TextMessage(obj.toJSONString()));
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //소켓 종료
        sessionMap.remove(session.getId());
        super.afterConnectionClosed(session, status);
    }

    private static JSONObject JsonToObjectParser(String jsonStr){
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try{
            obj = (JSONObject) parser.parse(jsonStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
