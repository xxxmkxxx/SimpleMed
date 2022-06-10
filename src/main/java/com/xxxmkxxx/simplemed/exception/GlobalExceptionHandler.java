package com.xxxmkxxx.simplemed.exception;

import com.xxxmkxxx.simplemed.common.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Message> authenticationExceptionHandler(AuthenticationException authenticationException) {
        String messageText = LocalDateTime.now() + "\n" + authenticationException.getMessage();
        Message message = new Message(messageText, Message.MessageType.ERROR);

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
