package com.xxxx.example;

import database_connection.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletRegister class works as a controller and pass variables to gateway.
@WebServlet("/listenRegister")
public class servletRegister extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String reEnterPassword = req.getParameter("reEnterPassword");
        boolean status = true;
        //set password != to !password.equals(reEnterPassword), since two String have different reference
        if (!password.equals(reEnterPassword)){
            status = false;
        }
        if (status) {
            req.getRequestDispatcher("/registerGateway").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/registerResponsePasswordInvalid").forward(req,resp);
        }
    }
}
