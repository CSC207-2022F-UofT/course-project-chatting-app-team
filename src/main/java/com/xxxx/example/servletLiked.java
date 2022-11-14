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
        Database myDatabase = new Database("mongodb+srv://K125_member2:asdf8765@cluster0.gnzfm1q.mongodb.net/test", "DatingAppStaging");
//        List<Document> doc2 = myDatabase.get_liked_count
//       post liked count
    }
}
