package com.levelup;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by Daitin on 20.11.2016.
 */

public class MyFirstServlet extends HttpServlet {
    @Override
    public void init() throws  ServletException {
        super.init();
        System.out.println("INIT SERVLET");
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        out.write(("Servlet work ok").getBytes());
        resp.setStatus(HttpServletResponse.SC_OK);
        out.close();
    }

    public static void main(String[] args) throws ServletException {
        MyFirstServlet firstServlet = new MyFirstServlet();
        firstServlet.init();


    }
}
