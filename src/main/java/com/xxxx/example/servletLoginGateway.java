package com.xxxx.example;

import database_connection.Database;
import database_connection.DatabaseRead;
import log_in_use_case.LoginPasswordCheck;
import user_exist_use_case.UserExistCheck;
import post_reply_user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletLoginGateway class works as a gateway and pass variables to presenter.
@WebServlet("/loginGateway")
public class servletLoginGateway extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        DatabaseRead myDatabase = new DatabaseRead(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
        User returnedUser = myDatabase.findUserById(username);
        myDatabase.close();
        UserExistCheck usernameCheck = new UserExistCheck();
        LoginPasswordCheck passwordCheck = new LoginPasswordCheck();
        boolean checkExist = usernameCheck.userExistCheck(returnedUser);
        boolean checkPassword = passwordCheck.loginPasswordCheck(returnedUser, password);
        if (checkExist && checkPassword) {
            req.getRequestDispatcher("/loginResponseSuccess").forward(req, resp);
        } else if (!checkExist) {
            req.getRequestDispatcher("/loginResponseUserNotExist").forward(req, resp);
        } else {
            req.getRequestDispatcher("/loginResponsePasswordIncorrect").forward(req, resp);
        }
    }
}
