package com.xxxx.example;

import database_connection.Database;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//这个是project文件
@WebServlet("/Servlet04")
public class Servlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        Database myDatabase = new Database("mongodb+srv://K125_member1:asdf4321@cluster0.jd1nala.mongodb.net/test", "DatingAppStaging");
        Document doc = myDatabase.find_user_by_id("541730");
        System.out.println(doc.toJson());
        resp.getWriter().append(doc.toJson());
    }
}
