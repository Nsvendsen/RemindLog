package com.remindlog.controllers;

import com.remindlog.models.ShareGroup;
import com.remindlog.models.User;
import com.remindlog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class CreateShareGroupController {

    private UserService userService;

    public CreateShareGroupController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/createShareGroup")
    public String createShareGroup(){

        return "/user/createShareGroup";
    }

    @RequestMapping(value = "/user/createShareGroup", method = RequestMethod.POST)
    public String createShareGroup(ShareGroup shareGroup, Principal principal){
        User theUser = userService.findAUserByUsername(principal.getName());
        theUser.createShareGroup(shareGroup); //Might cause some unexpected queries
        userService.saveAUser(theUser);
        return "/user/createShareGroup";
    }
}
