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

//这个是project文件
@WebServlet("/Servlet04")
public class Servlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Database myDatabase = new Database("<connection string goes here>", "DatingAppStaging");
        List<Document> doc2 = myDatabase.find_latest_posts(100);
         // user this to query for a user.
        for(int i = 0; i < doc2.toArray().length; i++){
            Document doc = doc2.get(i);
            resp.getWriter().append(doc.toJson() + "tbs010143fniwufwifnj+)4733&3uoghqgushvsjcvbjbke3bfb34uofuvhduvwb1=f");
        }


        System.out.println(doc2.toString());
    }
}
// <connection string goes here>