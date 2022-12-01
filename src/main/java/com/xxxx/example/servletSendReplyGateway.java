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
        String text = req.getParameter("text");
        String username = req.getParameter("username");
        String id = req.getParameter("id");
        Database myDatabase = new Database(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
        myDatabase.insert_reply(id, username, text);
        req.getRequestDispatcher("/sendReplyResponse").forward(req,resp);
    }
}