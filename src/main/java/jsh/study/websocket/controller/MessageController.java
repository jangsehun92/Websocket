package jsh.study.websocket.controller;

import jsh.study.websocket.dto.MessageDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class MessageController {

    @MessageMapping("/global")
    @SendTo("/topic/global")
    public MessageDto sendMessage(final MessageDto messageDto) {
        return messageDto;
    }

}
