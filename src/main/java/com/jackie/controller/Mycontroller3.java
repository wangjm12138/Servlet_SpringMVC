package com.jackie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//requestmapping的多个参数

@Controller
//@RequestMapping("/msb")
public class Mycontroller3 {

    //可以多个url
    @RequestMapping(value={"/firstController","/firstContorller2"})
    public String hello() {
        return "three";
    }

    //限定请求方法
    @RequestMapping(value = "testRequest2",method = RequestMethod.GET)
    public String hello2() {
        return "three";
    }

    //控制请求参数
    @RequestMapping(value = "testRequest3",params ="username")
    public String hello3() {
        return "three";
    }

    //控制请求参数
    @RequestMapping(value = "testRequest4",params ="username!=root")
    public String hello4() {
        return "three";
    }

    //控制请求头,字符串里面用key=value形式
    @RequestMapping(value = "testRequestHeader",headers ="Connection=keep-alive")
    public String hello5() {
        return "three";
    }
}
