package com.xxxx.example;

import database_connection.Database;
import log_in_use_case.LoginPasswordCheck;
import log_in_use_case.LoginUsernameCheck;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginGateway")
public class servletLoginGateway extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Database myDatabase = new Database("", "DatingAppStaging");
        Document returnedUser = myDatabase.find_user_by_id(username);
        boolean checkExist = LoginUsernameCheck.check(returnedUser);
        boolean checkPassword = LoginPasswordCheck.check(returnedUser, password);
        if (checkExist && checkPassword) {
            req.getRequestDispatcher("/loginResponseSuccess").forward(req, resp);
        } else if (!checkExist) {
            req.getRequestDispatcher("/loginResponseUserNotExist").forward(req, resp);
        } else {
            req.getRequestDispatcher("/loginResponsePasswordIncorrect").forward(req, resp);
        }
    }
}
