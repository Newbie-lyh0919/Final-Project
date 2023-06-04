package shop.HealthJava.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import shop.HealthJava.vo.ChatMessageVO;

@Controller
@RequiredArgsConstructor
public class StompChatController {
	
    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달

    // Client가 SEND할 수 있는 경로
    // stompConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
    // "/pub/chat/enter"
    @MessageMapping(value = "/chat/enter")
    public void enter(ChatMessageVO message){
        if (!"admin".equals(message.getWriter())) {
            ChatMessageVO welcomeMessage = new ChatMessageVO();
            welcomeMessage.setWriter("admin");
            welcomeMessage.setMessage("고객님! 자바헬스에 오신 걸 환영합니다. 관리자와의 채팅이 곧 연결됩니다.");
            template.convertAndSend("/sub/chat/room/" + message.getRoomId(), welcomeMessage);
        } else {
            ChatMessageVO adminMessage = new ChatMessageVO();
            adminMessage.setWriter("admin");
            adminMessage.setMessage("관리자님! 고객님과의 채팅이 시작됩니다.");
            template.convertAndSend("/sub/chat/room/" + message.getRoomId(), adminMessage);
        }
    } // end enter()

    @MessageMapping(value = "/chat/message")
    public void message(ChatMessageVO message){
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    } // end message()
	
} // end StompChatController class
