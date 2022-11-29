package com.xxxx.example;

import database_connection.Database;
import org.bson.Document;
import org.bson.BsonArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Servlet04")
public class Servlet04 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("application/json");
//
//        Database myDatabase = new Database("", "DatingAppStaging");
//
//        // Should probably move off this hardcoded 20 at some point
//        List<Document> postDocs = myDatabase.find_latest_posts(20);
//
//        // convert to a BsonArray
//        BsonArray postStrArray = new BsonArray();
//        for (Document post: postDocs) {
//            postStrArray.add(post.toBsonDocument());
//        }
//        myDatabase.close();
//
//        resp.getWriter().append(postStrArray.getValues().toString());
    }
}