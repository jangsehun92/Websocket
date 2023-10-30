package jsh.study.websocket.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CustomHandshakeInterceptor implements HandshakeInterceptor {

    final static List<String> SUPPORT_SUB_PROTOCOLS = Arrays.asList("jsh-protocol-1", "jsh-protocol-2");

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {
        // 서브프로토콜 확인
        String requestSubProtocols = request.getHeaders().getFirst("Sec-WebSocket-Protocol");

        if (requestSubProtocols != null) {
            for (String requestSubProtocol : requestSubProtocols.split(",")) {
                requestSubProtocol = requestSubProtocol.trim();
                if (SUPPORT_SUB_PROTOCOLS.contains(requestSubProtocol)) {
                    response.getHeaders().set("Sec-WebSocket-Protocol", requestSubProtocol);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                               Exception exception) {

    }

}
