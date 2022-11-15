package com.xxxx.example;

import database_connection.Database;
import register_use_case.UsernameCheck;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/registerGateway")
public class servletRegisterGateway extends HttpServlet {
    private boolean check;
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database myDatabase = new Database("", "DatingAppStaging");
        List<Document> allUsername = myDatabase.getAllUsername();
        String username = req.getParameter("username");
        String password = req.getParameter("/password");
        boolean check = UsernameCheck.check(allUsername, username);
        if (!check) {
            myDatabase.addUser(username, password);
            req.getRequestDispatcher("/registerResponse").forward(req, resp);
        } else {
            resp.getWriter().append("username already exist");
        }
    }

}