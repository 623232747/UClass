package org.BUPT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class frontController {
    @GetMapping("/")
    public String login() {
        return "login/index";
    }
    @GetMapping("/index")
    public String list(){
        return "index/list";
    }
}
