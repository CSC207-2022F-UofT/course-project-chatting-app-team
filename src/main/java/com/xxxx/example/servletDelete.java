package com.xxxx.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/listenDelete")
public class servletDelete extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Username = req.getParameter("current_user");
        String delete_id = req.getParameter("delete_id");

        req.setAttribute("username",Username);
        req.setAttribute("id",delete_id);
        req.getRequestDispatcher("/deleteGateway").forward(req,resp);
    }
}
