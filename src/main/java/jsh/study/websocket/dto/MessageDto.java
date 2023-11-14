package jsh.study.websocket.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class MessageDto {

    private String name;
    private String content;

}
