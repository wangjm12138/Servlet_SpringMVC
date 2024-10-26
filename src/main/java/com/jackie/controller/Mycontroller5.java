package com.jackie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//测试put,delete,get,post等restful风格的请求和testPutDelecte.jsp对应
//需要配置hiddenHttpMethodFilter来过滤post请求，内部转为put和delete请求

@Controller
//@RequestMapping("/msb")
public class Mycontroller5 {

    @RequestMapping("/testRest")
    public String hello() {
        return "testPutDelete";
    }


    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String hello1(@PathVariable("id") int id) {
        System.out.println("GET:"+id);
        return "three";
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.POST)
    public String hello2(@PathVariable("id") int id) {
        System.out.println("POST:"+id);
        return "three";
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public void hello3(@PathVariable("id") int id) {
        System.out.println("PUT:"+id);
//        return "three";
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public void hello4(@PathVariable("id") int id) {
        System.out.println("DELETE:"+id);
//        return "three";
    }
}
