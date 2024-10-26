package com.jackie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//dispatcherServlet->HandlerMapping先找到handler，也就是controller对应的方法返回给dispatcherServlet
//dispatcherServlet->handlerAdaptor把一些入参整理，然后调用handler，然后handler结果再返回adaptor
//dispatcherServlet->ViewResolver把结果传入到视图解析器，在返回View对象。
//最后dispatcherServle->渲染视图
//三大组件就是第1,2,3步，当然还得加上dispatcherServlet的中央控制器

//创建视图解析器的例子，路径的匹配:
@Controller
@RequestMapping("/msb")
public class MyController2 {


    @RequestMapping("/firstController")
    public String hello() {
        return "three";
    }


}
