package com.devops.integration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
    @GetMapping(value = "/hello")
    public String getMessage(){
        return "Hello, welcome!!";
    }
}
