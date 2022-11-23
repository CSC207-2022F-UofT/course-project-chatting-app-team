package com.xxxx.example;

import database_connection.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletLikeReply class works as a controller and pass variables to gateway.
// Not yet functioning (to be added later)
public class servletLikeReply extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String replyID = req.getParameter("replyID");
        String status = "success";
        Database myDatabase = new Database("", "DatingAppStaging");

        req.setAttribute("status", status);
        req.getRequestDispatcher("/likeReplyResponse").forward(req,resp);
    }
}
