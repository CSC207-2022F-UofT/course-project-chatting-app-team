package com.xxxx.example;

import database_connection.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletSendReplyGateway class works as a gateway and pass variables to presenter.
@WebServlet("/sendReplyGateway")
public class servletSendReplyGateway extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = (String) req.getParameter("text");
        String userName = (String) req.getParameter("userName");
        String id = (String) req.getParameter("id");
        Database myDatabase = new Database("", "DatingAppStaging");
        myDatabase.insert_reply(id, userName, text);
        req.getRequestDispatcher("/sendReplyResponse").forward(req,resp);
    }
}