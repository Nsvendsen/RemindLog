package com.remindlog.controllers;

import com.remindlog.models.User;
import com.remindlog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class EditUserController {

    private UserService userService;

    public EditUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/editUser")
    public String editUserController(Model model, Principal principal){
        User theUser = userService.findAUserByUsername(principal.getName());
        model.addAttribute("theUser", theUser);
        return "/user/editUser";
    }

    @RequestMapping(value = "/user/editUser", method = RequestMethod.POST)
    public String editUserController(User user, Principal principal){
        User theUser = userService.findAUserByUsername(principal.getName());
        userService.editUser(user, theUser);
        return "redirect:/logout"; //"/user/home"
    }
}
