package com.jackie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InterceptorController {

    @RequestMapping("interceptor.action")
    public String login(@RequestParam("uname") String uname, @RequestParam("password")String password){
        System.out.println(11111);
        return "success";
    }
}
