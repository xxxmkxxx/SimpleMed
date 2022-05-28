package com.xxxmkxxx.simplemed.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainPageController {
    @GetMapping("/")
    public String mainPage() {
        return "Привет!";
    }
}
