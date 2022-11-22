package com.xxxx.example;

import database_connection.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletLikePostGateway class works as a gateway and pass variables to presenter.
@WebServlet("/listenLikedEvent")
public class servletLikePostGateway extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        String current_user = req.getParameter("current_user");
        String post_id = req.getParameter("post_id");
        String event_type = req.getParameter("event_type");

        Database myDatabase = new Database("", "DatingAppStaging");
        if(event_type.equals("liked")){
            myDatabase.like(current_user,post_id);
            req.getRequestDispatcher("/likePostResponseLike").forward(req,resp);
        } else if (event_type.equals("unliked")) {
            myDatabase.unlike(current_user,post_id);
            req.getRequestDispatcher("/likePostResponseDislike").forward(req,resp);
        }
    }
}
