package com.youwang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        // get captcha from request
        String captcha = (String) req.getSession().getAttribute("captcha");
        // get user name and password from request
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter printWriter = resp.getWriter();
        // check captcha
        if (!req.getParameter("captcha").equals(captcha.toLowerCase())) {
            printWriter.write("wrong captcha");
            return;
        }
        // check user and password
        if ("admin".equals(username) && "123456".equals(password)) {
            printWriter.write("Login Success!");
        } else {
            printWriter.write("Login Fail! Wrong User or Password!");
        }
    }
}
