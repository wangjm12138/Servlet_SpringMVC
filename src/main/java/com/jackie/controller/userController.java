package com.jackie.controller;


import com.jackie.POJO.User;
import com.jackie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class userController {

    @Autowired
    private UserService userService;

    @RequestMapping("login.action")
    public String login(@RequestParam("uname") String uname, @RequestParam("password") String password) {
        String view = "";
        User user = userService.findUser(uname, password);
        if(user != null) {
            view = "/success";
        } else {
            view = "/fail";
        }
        return view;
    }
}
