package com.remindlog.controllers;

import com.remindlog.models.User;
import com.remindlog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

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
    public String createUser(User user){ //HttpServletRequest request,

//        String passwordVal = request.getParameter("passwordVal");
//        System.out.println(passwordVal);

        if (user.getPassword().equals(user.getPasswordVal()))
            userService.createUser(user);
        else
            System.out.println("Error! Passwords entered does not match!");
        return "/login";
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
