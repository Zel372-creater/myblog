package com.blog.myblog.conrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserControllers {

    @GetMapping("/login")
    public String loginUser(){
        return "login";
    }
}
