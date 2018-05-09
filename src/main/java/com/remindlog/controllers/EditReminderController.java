package com.remindlog.controllers;

import com.remindlog.models.Reminder;
import com.remindlog.models.User;
import com.remindlog.services.ReminderService;
import com.remindlog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class EditReminderController {

    private UserService userService;
    private ReminderService reminderService;

    public EditReminderController(UserService userService, ReminderService reminderService) {
        this.userService = userService;
        this.reminderService = reminderService;
    }

    @RequestMapping("/user/editReminder/{name}")
    public String editReminder(@PathVariable String name, Principal principal, Model model){
        User theUser = userService.findAUserByUsername(principal.getName());
        Reminder reminder = reminderService.findAReminderByNameAndUser(name, theUser);
        model.addAttribute("theReminder", reminder);
        return "/user/editReminder";
    }

    @RequestMapping(value = "/user/editReminder/{name}", method = RequestMethod.POST)
    public String editReminder(@PathVariable String name, Reminder reminder, Model model, Principal principal){
        User theUser = userService.findAUserByUsername(principal.getName());
//        model.addAttribute("theReminder", reminder);
        reminderService.deleteReminder(reminderService.findAReminderByNameAndUser(name, theUser)); //test
        theUser.addReminder(reminder);
        userService.saveAUser(theUser);
//        reminderService.saveAReminder(reminder);
        return "redirect:/user/viewReminders";
    }
}
