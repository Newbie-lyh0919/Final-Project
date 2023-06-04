package shop.HealthJava.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableWebSocketMessageBroker
@Configuration
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // endpoint를 /stomp로 하고, allowedOrigins를 "*"로 하면 페이지에서
    // Get /info 404 Error가 발생한다. 그래서 아래와 같이 2개의 계층으로 분리하고
    // origins를 개발 도메인으로 변경하니 잘 동작하였다.
    // 이유는 왜 그런지 아직 찾지 못함
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp/chat")
                .setAllowedOriginPatterns("*") // 모든 도메인에서 접속 가능 / 보안상의 이유로 특정 도메인만 허용하는 것이 좋음
                .withSockJS();
    } // end registerStompEndpoints()

    /* 어플리케이션 내부에서 사용할 path를 지정할 수 있음 */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/pub");
        registry.enableSimpleBroker("/sub");
    } // end configureMessageBroker()
    
} // end StompWebSocketConfig class