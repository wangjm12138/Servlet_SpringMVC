package com.jackie.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet("/myServlet.do")
public class Servlet1 extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        ServletContext servletContext1 = this.getServletContext();
        System.out.println(servletContext1 == servletContext);
        System.out.println(servletContext1.getInitParameter("username"));
        System.out.println(servletContext1.getInitParameter("password"));
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println(servletConfig.getInitParameter("brand"));
//        req.getRequestDispatcher("three.jsp").forward(req,resp);

//转发两种方法，forward和include

        //1.请求转发是服务器的行为，是对浏览器屏蔽的
        //2.浏览器地址不会发生变化.
        //3.请求的参数是可以从源组件到目标组件
        //4.请求对象和响应没有重新创建，而是传递给了目标组件。（forward会清空源组件的servlet req和resp）
        //5.请求转发可以转发到页面JSP和html
        //6.可以请求转发到WEB-INF（受保护资源）里面的资源。
        //7.请求转发，只能转发给当前项目的内部资源

        //如果用forward给其他servlet，当前给resp里面塞的各种数据都无效了
//        req.getRequestDispatcher("myServlet2").forward(req, resp);

        //include 模式
        //这种模式下，是给其他servlet处理，再返回来，所以实际上是当前servlet返回的，所以可以给resp塞数据
         req.getRequestDispatcher("myServlet2").include(req, resp);

        //web-inf
//        req.getRequestDispatcher("WEB-INF/a.html").forward(req, resp);

        //重定向
        resp.sendRedirect("myServlet2");

    }
}
