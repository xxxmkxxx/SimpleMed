package com.xxxmkxxx.simplemed.features.user.controllers;

import com.xxxmkxxx.simplemed.common.Message;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
@AllArgsConstructor
public class AdminUserController {
    @PostMapping("/delete")
    protected ResponseEntity<Message> deleteUser() {
        return new ResponseEntity<>(new Message("war", Message.MessageType.WARNING), HttpStatus.OK);
    }
}
