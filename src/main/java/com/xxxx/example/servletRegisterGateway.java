package com.xxxx.example;

import database_connection.Database;
import org.bson.types.ObjectId;
import post_reply_user.CommonUser;
import post_reply_user.User;
import register_use_case.RegisterUsernameCheck;
import org.bson.Document;
import register_use_case.ReturnAsUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletRegisterGateway class works as a gateway and pass variables to presenter.
@WebServlet("/registerGateway")
public class servletRegisterGateway extends HttpServlet {
    private boolean check;
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database myDatabase = new Database("", "DatingAppStaging");
        String username = req.getParameter("username");
        CommonUser returnedUsername = myDatabase.find_user_by_id(username);
        String password = req.getParameter("password");
        boolean check = RegisterUsernameCheck.check(returnedUsername);
        if (check) {
            CommonUser user = ReturnAsUser.returnUser(username, password, null);
            myDatabase.insert_user(user);
            myDatabase.close();
            req.getRequestDispatcher("/registerResponse").forward(req, resp);
        } else {
            req.getRequestDispatcher("/registerResponseUserExist").forward(req, resp);
        }
    }

}