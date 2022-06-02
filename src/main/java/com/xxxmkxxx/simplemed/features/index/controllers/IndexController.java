package com.xxxmkxxx.simplemed.features.index.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/index")
@AllArgsConstructor
public class IndexController {
    @GetMapping("")
    public String index() {
        return "hello start page!";
    }
}
