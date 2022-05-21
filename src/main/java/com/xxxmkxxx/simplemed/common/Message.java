package com.xxxmkxxx.simplemed.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Message {
    private String text;
    private MessageType type;

    public enum MessageType {
        MESSAGE, ERROR, WARNING, SUCCESS
    }
}
