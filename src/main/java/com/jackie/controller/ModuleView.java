package com.jackie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
public class ModuleView {

    @RequestMapping("demoView")
    public View forward(){
        View view = new InternalResourceView("/forward.jsp");
        return view;
    };
    @RequestMapping("demoView2")
    public View redirect(){
        View view = new InternalResourceView("/redirect.jsp");
        return view;
    };


    @RequestMapping("demoView3")
    public ModelAndView modelAndView(){
        ModelAndView mv = new ModelAndView();
        //forward 两种方式，一种设置视图名字，另一种new进来internalresourceview对象
        //mv.setViewName("forward:/forward.jsp");
        //mv.setView(new InternalResourceView("/forward.jsp"));
        //redirect两种方式，同理
        mv.setViewName("redirect:/redirect.jsp");
        mv.setView(new InternalResourceView("/redirect.jsp"));
        return mv;
    };
}
