package com.remindlog.controllers;

import com.remindlog.models.User;
import com.remindlog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/createUser")
    public String createUser(){

        return "/createUser";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(User user){
        userService.createUser(user);
        return "/createUser";
    }

    @RequestMapping(value = {"", "/", "/login"})
    public String login(){

        return "/login";
    }

    @RequestMapping("/user/home")
    public String home(){

        return "/user/home";
    }
}
