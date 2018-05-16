package com.remindlog.controllers;

import com.remindlog.models.User;
import com.remindlog.services.ReminderService;
import com.remindlog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ViewRemindersController {

    private UserService userService;
    private ReminderService reminderService;

    public ViewRemindersController(UserService userService, ReminderService reminderService) {
        this.userService = userService;
        this.reminderService = reminderService;
    }

    @RequestMapping("/user/viewReminders")
    public String viewReminders(Model model, Principal principal){
        User theUser = userService.findAUserByUsername(principal.getName());
        model.addAttribute("theReminders", theUser.getReminders());
        return "/user/viewReminders";
    }

    @RequestMapping("/user/deleteReminder/{id}")
    public String deleteReminder(@PathVariable Long id){
        reminderService.deleteReminderById(id);
        return "redirect:/user/viewReminders";
    }
}
