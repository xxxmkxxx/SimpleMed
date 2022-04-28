package com.xxxmkxxx.simplemed.controllers;

import com.xxxmkxxx.simplemed.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class MainPageController {
    private UsersRepository repository;

    @GetMapping("")
    public String mainPage() {
        System.out.println(repository.getUserModelByUserId(1).getName());
        return "startPage";
    }
}
