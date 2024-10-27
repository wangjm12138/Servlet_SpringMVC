package com.jackie.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class ForwardRedirect {

//原生的方式,转发和重定向
    @RequestMapping("forward")
    public void forward(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //req.getRequestDispatcher("/forward.jsp").forward(req, res);
        res.sendRedirect(req.getContextPath()+"/redirect.jsp");
    }

    //springmvc的方式,转发和重定向
    @RequestMapping("forward2")
    public String forward2(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        //可以直接不写forward，但是我建议写；
        //return "forward:/forward.jsp";
        //return "/forward.jsp";

        //重定向，不可以不写redirect
        return "redirect:/redirect.jsp";
    }
}
