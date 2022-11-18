package com.xxxx.example;

import database_connection.Database;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listenLiked")
public class servletLiked extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        String current_user = req.getParameter("current_user");
        String post_id = req.getParameter("post_id");
        String event_type = req.getParameter("event_type");

        //Does not need a gateway since there's no other execution
        Database myDatabase = new Database("", "DatingAppStaging");
        if(event_type.equals("liked")){

            myDatabase.like(current_user,post_id);
            System.out.println(myDatabase.find_latest_posts(1));
            resp.getWriter().append("succeed to like");
        } else if (event_type.equals("unliked")) {

            myDatabase.unlike(current_user,post_id);
            resp.getWriter().append("succeed to dislike");
        }
    }
}
