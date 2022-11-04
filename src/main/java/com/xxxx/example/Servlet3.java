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
@WebServlet("/ser03")
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前端字符
        req.setCharacterEncoding("UTF-8");
        String get = req.getParameter("text");
        String hydragel = req.getParameter("time");
        System.out.println("接收前端信息: "+ get);
        System.out.println("接收前端时间:"+ hydragel);

        //上传到数据库 commit前请不要暴露地址
        Database myDatabase = new Database("mongodb+srv://K125_member1:rewq4321@cluster0.jd1nala.mongodb.net/test", "DatingAppStaging");
        myDatabase.insert_post("tianxianbaobao", get);
        List<Document> doc2 = myDatabase.find_latest_posts(1);

        // user this to query for a user.
        Document doc = doc2.get(0);

        System.out.println(doc2.toString());
        resp.getWriter().append(doc.toJson());
    }
}
