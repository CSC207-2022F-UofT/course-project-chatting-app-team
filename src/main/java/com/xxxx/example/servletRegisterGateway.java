package com.xxxx.example;

import database_connection.Database;
import database_connection.DatabaseInsert;
import database_connection.DatabaseRead;
import user_exist_use_case.UserExistCheck;
import post_reply_user.CommonUser;
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

        DatabaseRead myDatabase = new DatabaseRead(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
        String username = req.getParameter("username");
        CommonUser returnedUsername = myDatabase.findUserById(username);
        String password = req.getParameter("password");
        UserExistCheck userCheck = new UserExistCheck();
        boolean check = userCheck.userExistCheck(returnedUsername);
        myDatabase.close();
        if (!check) {
            ReturnAsUser returnUser = new ReturnAsUser();
            CommonUser user = returnUser.returnUser(username, password, null);
            DatabaseInsert databaseInsert = new DatabaseInsert(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
            databaseInsert.insertUser(user);
            databaseInsert.close();
            req.getRequestDispatcher("/registerResponse").forward(req, resp);
        } else {
            req.getRequestDispatcher("/registerResponseUserExist").forward(req, resp);
        }
    }

}