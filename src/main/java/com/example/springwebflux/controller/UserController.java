package com.example.springwebflux.controller;

import com.example.springwebflux.User;
import com.example.springwebflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/greeting",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> greeting() {
        return userService.getData();
    }
}
