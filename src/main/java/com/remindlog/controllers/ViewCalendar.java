package com.remindlog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewCalendar {

    @RequestMapping("/user/viewCalendar")
    public String viewCalendar(){
        return "/user/viewCalendar";
    }
}
