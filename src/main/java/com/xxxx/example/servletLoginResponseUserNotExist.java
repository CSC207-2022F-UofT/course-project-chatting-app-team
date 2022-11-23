package com.xxxx.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletLoginResponseUserNotExist class works as a presenter and pass user not exist message back to front-end.
@WebServlet("/loginResponseUserNotExist")
public class servletLoginResponseUserNotExist extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("not_exist");
    }
}