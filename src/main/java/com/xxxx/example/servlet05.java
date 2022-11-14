package com.xxxx.example;

import database_connection.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ser05")
public class servlet05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String get = req.getParameter("text");
        String userName = req.getParameter("userName");

        Database myDatabase = new Database("mongodb+srv://K125_member2:asdf8765@cluster0.gnzfm1q.mongodb.net/test", "DatingAppStaging");
        myDatabase.insert_post(userName, get);
        req.getRequestDispatcher("/ser06").forward(req,resp);
    }
}

