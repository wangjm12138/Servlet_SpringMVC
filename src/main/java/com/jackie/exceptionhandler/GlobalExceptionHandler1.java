package com.jackie.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//第二种处理异常方式，全局扫描，有任何controller出现异常，都会被捕获，还要试一下如果第一种和第二种都配置会出现什么结果
//@ControllerAdvice
//public class GlobalExceptionHandler1 {
//
//    @ExceptionHandler(value = {ArithmeticException.class})
//    public ModelAndView handlException(){
//        ModelAndView modelAndView = new ModelAndView();
////        Map<String, Object> model = modelAndView.getModel();
//        modelAndView.setViewName("Exception");
//        return modelAndView;
//    }
//
//    @ExceptionHandler(value = {NullPointerException.class})
//    public ModelAndView handlException2(){
//        ModelAndView modelAndView = new ModelAndView();
////        Map<String, Object> model = modelAndView.getModel();
//        modelAndView.setViewName("Exception");
//        return modelAndView;
//    }
//}
