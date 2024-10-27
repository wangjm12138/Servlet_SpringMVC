package com.jackie.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ScopeController {

    @ResponseBody
    @RequestMapping("get")
    public String setData(HttpServletRequest request) {
        //旧方式来获取servletContext和httpSession，httpsession其实是和cookie结合的一种方式
        // 比如当客户成功登录，服务端创建一个session对象，同时会给客户端返回一个cookie，jessionid的字符串
        //这样session和cookie是对应的，一个session对象就是对应这个id的jessionid
        // 当客户端发送请求时候，会带上这个cookie时候，那么再获取httpsession时候就是之前创建的session对象。
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();

        return "get success";
    }

    @RequestMapping("showdata")
    public String setData2(HttpServletRequest request, HttpSession session) {
        //新方式,可以一次性直接获取请求域，session，但是全局application的servletContext还是得通过request获取
        request.setAttribute("message", "reqxxx");

        session.setAttribute("message", "sessionxxx");

        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("message", "servletContextxxx");

        return "showData";
    }


    @RequestMapping("showdata2")
    public String setData3(Model model) {

        //model对象的addattribute，主要是对请求域进行塞数据
        //如果是重定向，会向请求的url后面添加这些键值对转发给目标jsp。在jsp中可以用requestparam里面获取数据。
        model.addAttribute("message", "reqxxx");
        return "showData";
    }

    @RequestMapping("showdata3")
    public ModelAndView setData4() {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> model = mav.getModel();
        model.put("message", "reqxxx");
        mav.setViewName("showData");
        //和上面一样的，都是request域
        return mav;
    }
}
