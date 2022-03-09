package com.example.springwebflux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebSocketController {

    @GetMapping("/websocket")
    public String showUserList(Model model) {
        model.addAttribute("name");
        return "ws-broadcast";
    }
}
