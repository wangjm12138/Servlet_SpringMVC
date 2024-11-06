package com.jackie.controller;


import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/myServlet4"})
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("xxxx");
        out.flush();
        ArrayList<String> objects = new ArrayList<>();
        AsyncContext asyncContext = req.startAsync();
        asyncContext.addListener(new AsyncServletListener());
        doWork(asyncContext,objects);
        out.println("wancheng");
        out.flush();
    }

    public void doWork(AsyncContext asyncContext,ArrayList<String> list){
        asyncContext.setTimeout(60*60*1000L);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    PrintWriter writer = asyncContext.getResponse().getWriter();
                    for (String job: list){
                        writer.println(job);
                        Thread.sleep(1000);
                        writer.flush();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}
