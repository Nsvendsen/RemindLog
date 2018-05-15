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

    @RequestMapping("/user/editReminder/{id}") //{name}
    public String editReminder(@PathVariable Long id, Principal principal, Model model){
        User theUser = userService.findAUserByUsername(principal.getName()); //redundant?
//        Reminder reminder = reminderService.findAReminderByNameAndUser(name, theUser); //Really bad since name has to be unique for every user, find alternative solution
        Reminder reminder = reminderService.findAReminderById(id); //Find reminder by ID alternative???
        model.addAttribute("theReminder", reminder);
        return "/user/editReminder";
    }

    @RequestMapping(value = "/user/editReminder", method = RequestMethod.POST) //pathvariable might not be needed. /{name}
    public String editReminder(Reminder reminder){ //@PathVariable String name,
        reminderService.editReminder(reminder);
        return "redirect:/user/viewReminders";
    }
}
