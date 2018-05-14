package com.remindlog.controllers;

import com.remindlog.models.User;
import com.remindlog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ViewRemindersController {

    private UserService userService;

    public ViewRemindersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/viewReminders")
    public String viewReminders(Model model, Principal principal){
        User theUser = userService.findAUserByUsername(principal.getName());
        model.addAttribute("theReminders", theUser.getReminders());
        return "/user/viewReminders";
    }
}
