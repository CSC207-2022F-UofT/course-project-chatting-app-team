package com.xxxx.example;

import database_connection.Database;
import org.bson.types.ObjectId;
import register_use_case.UsernameCheck;
import org.bson.Document;

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
        String username = req.getParameter("username");
        Document returnedUsername = myDatabase.find_user_by_id(username);
        String password = req.getParameter("password");
        boolean check = UsernameCheck.check(returnedUsername);
        if (check) {
            myDatabase.insert_user(new Document()
                    .append("_id", new ObjectId())
                    .append("user_id", username)
                    .append("password", password));
            req.getRequestDispatcher("/registerResponse").forward(req, resp);
        } else {
            req.getRequestDispatcher("/registerResponseUserExist").forward(req, resp);
        }
    }

}