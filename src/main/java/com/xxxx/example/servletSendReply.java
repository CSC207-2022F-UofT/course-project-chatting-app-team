package com.xxxx.example;

import database_connection.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/listenReply")
public class servletSendReply extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String text = req.getParameter("text");
        String username = req.getParameter("username");
        String post_id = req.getParameter("post_id"); //

//        Database myDatabase = new Database("", "DatingAppStaging");
//        myDatabase.insert_reply(post_id, username, text); //
        System.out.println(text);
        System.out.println(username);
        System.out.println(post_id);

        Database myDatabase = new Database("","DatingAppStaging");
        myDatabase.insert_reply(post_id,username,text);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().append("success");
    }
}