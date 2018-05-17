package com.remindlog.controllers;

import com.remindlog.models.Reminder;
import com.remindlog.models.ReminderPost;
import com.remindlog.models.ShareGroup;
import com.remindlog.models.User;
import com.remindlog.services.ReminderService;
import com.remindlog.services.ShareGroupService;
import com.remindlog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class CreateReminderController {

    private UserService userService;
    private ShareGroupService shareGroupService;
    private ReminderService reminderService;

    public CreateReminderController(UserService userService, ShareGroupService shareGroupService, ReminderService reminderService) {
        this.userService = userService;
        this.shareGroupService = shareGroupService;
        this.reminderService = reminderService;
    }

    @RequestMapping("/user/createReminder")
    public String createReminder(Model model, Principal principal){

        User theUser = userService.findAUserByUsername(principal.getName());
        model.addAttribute("shareGroups", theUser.getShareGroups());//Choose sharegroup in dropdown list

        return "/user/createReminder";
    }

    @RequestMapping(value = "/user/createReminder", method = RequestMethod.POST)
    public String createReminder(ReminderPost reminderPost, Principal principal, Model model){ //Reminder reminder
        User theUser = userService.findAUserByUsername(principal.getName());

        model.addAttribute("shareGroups", theUser.getShareGroups());//Choose sharegroup in dropdown list
        //ERROR hvis brugeren vælger none i frontend! BAD PRACTICE
        ShareGroup shareGroup;
        if (reminderPost.getShareGroupId() == null)
            shareGroup = new ShareGroup();
        else
            shareGroup = shareGroupService.findShareGroupById(reminderPost.getShareGroupId());
        //Laver unødvendige SQL statements af ukendt årsag...
        theUser.addReminder(reminderService.convertReminder(reminderPost, shareGroup));

//        theUser.addReminder(reminder);
        userService.saveAUser(theUser);
        return "/user/createReminder";
    }
}
