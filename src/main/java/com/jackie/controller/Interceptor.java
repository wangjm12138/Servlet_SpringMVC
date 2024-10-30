package com.jackie.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//拦截器SpringMVC的，而过滤器servlet的
//拦截器不依赖于Servlet容器，由spring容器初始化，过滤器依赖于servlet容器，由servlet容器初始化
//拦截器可以访问control里面上下文，值栈里面的对象，而过滤不能访问
//在contorl的生命周期中，拦截器可以多次被调用，过滤器只能在容器初始化时被调用一次
//拦截器可以获取IOC容器中的各个bean，而过滤就不太方便，在拦截器里面注入一个service可以调用业务逻辑
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre handle");
        //true表示放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post handle");
    }

    //视图在渲染的时候，比如JSP里面有打印语句时候，打印完后，JSP整个就渲染完了，会执行这个afterCompletion
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
