package com.xxxmkxxx.simplemed.features.home.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainPageController {
    @GetMapping("/")
    public String mainPage() {
        return "hello world!";
    }
}
