package com.jackie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
//异常处理第一种方式
@Controller
public class ExceptionController {

    @RequestMapping("test")
    public String test1(){

        int i = 1/0;

        return "success";
    }

    @RequestMapping("test2")
    public String test2(){

        String s=null;
        System.out.println(s.charAt(1));

        return "success";
    }
    //可以定义多种异常
//    @ExceptionHandler(value={ArithmeticException.class})
//    //@ExceptionHandler(value={ArithmeticException.class,NullPointerException.class})
//    public ModelAndView handleError(){
//        ModelAndView modelAndView = new ModelAndView();
////        Map<String, Object> model = modelAndView.getModel();
//        modelAndView.setViewName("Exception");
//        return modelAndView;
//    }
}
