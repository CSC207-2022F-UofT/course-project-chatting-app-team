package com.xxxx.example;

import database_connection.Database;
import database_connection.DatabaseUpdate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// The servletLikePostGateway class works as a gateway and pass variables to presenter.
@WebServlet("/listenLikedEvent")
public class servletLikePostGateway extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        //Security: session to check if information is right
        HttpSession session = req.getSession();
        String currentUser = (String) session.getAttribute("username");
        if(currentUser == null){
            resp.sendError(412,"Fail to send the post, wrong session!!!");
            return;
        }

        String postId = req.getParameter("post_id");
        String eventType = req.getParameter("event_type");

        DatabaseUpdate myDatabase = new DatabaseUpdate(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
        if(eventType.equals("liked")){
            myDatabase.like(currentUser,postId);
            myDatabase.close();
            req.getRequestDispatcher("/likePostResponseLike").forward(req,resp);
        } else if (eventType.equals("unliked")) {
            myDatabase.unlike(currentUser,postId);
            myDatabase.close();
            req.getRequestDispatcher("/likePostResponseDislike").forward(req,resp);
        }
    }
}
