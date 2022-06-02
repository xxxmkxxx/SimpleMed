package com.xxxmkxxx.simplemed.features.user.controllers;

import com.xxxmkxxx.simplemed.common.Message;
import com.xxxmkxxx.simplemed.requests.CreateUserRequest;
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
    public ResponseEntity<Message> register(@RequestBody CreateUserRequest createUserRequest) {
        Message message = userService.createUser(createUserRequest);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
