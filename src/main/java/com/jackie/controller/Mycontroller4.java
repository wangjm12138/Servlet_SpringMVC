package com.jackie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//PathVariable注解使用

@Controller
//@RequestMapping("/msb")
public class Mycontroller4 {

    //可以多个url
    @RequestMapping("/path/{id}/text")
    public String hello(@PathVariable("id") String id) {
        System.out.println("id:"+id);
        return "three";
    }

    //类型会自动转换
    @RequestMapping("/path2/{id}/text")
    public String hello2(@PathVariable("id") Integer id) {
        System.out.println("Integer id:"+id);
        return "three";
    }
}
