package com.jackie.controller;

import com.jackie.POJO.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@SessionAttributes 注解必须应用于控制器类。
//@SessionAttributes 注解声明的属性会被自动存储到 Session 中，即使控制器方法没有显式地将它们添加到模型中。
//@SessionAttributes 注解可以与 @ModelAttribute 注解一起使用，以控制模型属性的生命周期。
//-------------------------------------------
//@SessionAttribute 是 Spring 中用于访问和管理 HTTP 会话中存储数据的注解。它允许你：
//
//获取会话属性： 将会话属性直接注入到控制器方法中。
//修改会话属性： 更新现有属性或添加新属性。
//删除会话属性： 从会话中清除属性。
//如果 Session 中不存在名为 "user" 的属性，或者该属性的值不是 User 类型的对象，那么会根据 required 属性的值来决定如何处理：
//如果 required=true（默认值），则会抛出异常。
//如果 required=false，则 user 参数的值为 null。
@Controller
@SessionAttributes("user")
public class sessionAttributesLearning {

    @GetMapping("/profile")
    public String profile(@SessionAttribute("user") User user) {
        // 从 Session 中获取 "user" 属性
        return "profile";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        Model model) {
        // 验证用户并存储到 Session 中
        User user = authenticate(username);
        model.addAttribute("user", user);
        return "redirect:/profile";
    }

    private User authenticate(String username) {
        User user = new User(1,"zhang","123456");
        return user;
    }
}