package com.xxxx.example;

import database_connection.Database;

import database_connection.DatabaseDelete;
import database_connection.DatabaseRead;
import org.bson.Document;
import post_reply_user.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletDeleteGateway class works as a gateway and pass variables to presenter.
@WebServlet("/deleteGateway")
public class servletDeleteGateway extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseRead myDatabase = new DatabaseRead(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
        String username = req.getParameter("username");
        String deleteId = req.getParameter("id");
        String status;

        Post post_sender = myDatabase.findPostById(deleteId);
        myDatabase.close();
        String sender = post_sender.getUserId();
        if(sender.equals(username)){
            status = "success";
            DatabaseDelete databaseDelete = new DatabaseDelete(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
            databaseDelete.deletePostById(deleteId);
            databaseDelete.close();
        }
        else {
            status = "fail";
        }
        req.setAttribute("status",status);
        req.getRequestDispatcher("/deleteResponse").forward(req,resp);
    }
}
