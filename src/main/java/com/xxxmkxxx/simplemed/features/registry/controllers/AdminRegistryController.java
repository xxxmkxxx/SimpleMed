package com.xxxmkxxx.simplemed.features.registry.controllers;

import com.xxxmkxxx.simplemed.common.Message;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/registry/")
@AllArgsConstructor
public class AdminRegistryController {
    @PostMapping("/appointment/delete")
    protected ResponseEntity<Message> deleteAppointment() {
        return new ResponseEntity<>(new Message("war", Message.MessageType.WARNING), HttpStatus.OK);
    }
}
