package com.xxxmkxxx.simplemed.features.user.controllers;

import com.xxxmkxxx.simplemed.common.Message;
import com.xxxmkxxx.simplemed.dao.CreateUserDAO;
import com.xxxmkxxx.simplemed.features.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Message> register(@RequestBody CreateUserDAO createUserDAO) {
        Message message = userService.createUser(createUserDAO);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
