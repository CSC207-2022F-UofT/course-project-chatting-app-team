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
//        req.setCharacterEncoding("UTF-8");
//        String get = req.getParameter("text");
//        String userName = req.getParameter("userName");
//
//        Database myDatabase = new Database("", "DatingAppStaging");
//        myDatabase.insert_post(userName, get);
//        myDatabase.close();
//        req.getRequestDispatcher("/ser06").forward(req,resp);
    }
}

