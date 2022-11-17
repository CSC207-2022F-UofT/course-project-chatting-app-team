package com.xxxx.example;

import database_connection.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servletSendReply extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String text = req.getParameter("text");
        String userName = req.getParameter("userName");
        String id = req.getParameter("id"); //

        Database myDatabase = new Database("", "DatingAppStaging");
        myDatabase.insert_reply(id, userName, text); //
        req.getRequestDispatcher("/postPostResponse").forward(req,resp);
    }
}