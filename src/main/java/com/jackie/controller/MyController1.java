package com.jackie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//没有创建视图解析器的例子，路径的匹配:
//1.springmvc和servlet是可以共存的，可以看到可以访问servlet2，也可以访问controller，其实springmvc
//就是一个servelet而已
//2.当类方法上面加了/msb时候，会以webapp下面路径开始来寻找文件，所以需要再webapp下面创建msb的文件夹
@Controller
//@RequestMapping("/msb")
public class MyController1 {

    //这样不会到msb目录下找msb,这样还是以webapp为目标路径
//    @RequestMapping("/msb")
    //这样可以到msb目录下找msb，这样会找到msb.jsp，这样就会变成webapp/msb了
    @RequestMapping("/msb/1")
    public String hello() {
        return "msb.jsp";
    }

//    @RequestMapping("firstController.do")
//    public String hello() {
//        return "msb.jsp";
//    }

    @RequestMapping("/secondController")
    public String hello2() {
        return "second.jsp";
    }

    @RequestMapping("/threeController")
    public String hello3() {
        return "/WEB-INFO/three.jsp";
    }
}
