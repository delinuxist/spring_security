package com.example.spring_security.home;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class HomeController {
    @Value("${welcome.message}")
    private String message;

    @GetMapping
    public String home() {
        return message;
    }
}
