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

@WebServlet("/ser06")
public class servlet06 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        Database myDatabase = new Database("", "DatingAppStaging");
        List<Document> doc2 = myDatabase.find_latest_posts(1);
        Document doc = doc2.get(0);
        resp.getWriter().append(doc.toJson() + "tbs010143fniwufwifnj+)4733&3uoghqgushvsjcvbjbke3bfb34uofuvhduvwb1=f");
    }
}
