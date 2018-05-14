package com.remindlog.controllers;

import com.remindlog.models.Reminder;
import com.remindlog.models.User;
import com.remindlog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class CreateReminderController {

    private UserService userService;

    public CreateReminderController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/createReminder")
    public String createReminder(){

        return "/user/createReminder";
    }

    @RequestMapping(value = "/user/createReminder", method = RequestMethod.POST)
    public String createReminder(Reminder reminder, Principal principal){
        User theUser = userService.findAUserByUsername(principal.getName());
        theUser.addReminder(reminder);
        userService.saveAUser(theUser);
        return "/user/createReminder";
    }
}
