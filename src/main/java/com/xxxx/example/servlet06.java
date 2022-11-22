package com.xxxx.example;

import database_connection.Database;
import org.bson.BsonArray;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ser06")
public class servlet06 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Database myDatabase = new Database("", "DatingAppStaging");
        List<Document> postDocs = myDatabase.find_latest_posts(1);

        // convert to a BsonArray
        BsonArray postStrArray = new BsonArray();
        for (Document post: postDocs) {
            postStrArray.add(post.toBsonDocument());
        }

        // System.out.print(postStrArray.getValues());
        resp.getWriter().append(postStrArray.getValues().toString());
    }
}
