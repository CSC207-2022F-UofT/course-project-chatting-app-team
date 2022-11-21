package com.xxxx.example;

import database_connection.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletPostPostGateway class works as a gateway and pass variables to presenter.
@WebServlet("/postPostGateway")
public class servletPostPostGateway extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = (String) req.getParameter("text");
        String userName = (String) req.getParameter("userName");
        Database myDatabase = new Database("", "DatingAppStaging");
        myDatabase.insert_post(userName, text);
        req.getRequestDispatcher("/postPostResponse").forward(req,resp);
    }
}
