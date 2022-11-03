package com.xxxx.example;

import database_connection.Database;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//这个是project文件
@WebServlet("/ser03")
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前端字符
        String get = req.getParameter("text");
        String hydragel = req.getParameter("time");
        System.out.println("接收前端信息: "+ get);
        System.out.println("接收前端时间:"+ hydragel);

        //上传到数据库
        Database myDatabase = new Database("mongodb+srv://K125_member1:qwer1234@cluster0.jd1nala.mongodb.net/test", "DatingAppStaging");
        myDatabase.insert_user (new Document()
                .append("_id", new ObjectId())
                .append("user_id", "541730")
                .append("your_own_property", get)
                .append("theTime", hydragel));

        // user this to query for a user.
        Document doc = myDatabase.find_user_by_id(hydragel);

        System.out.println(doc);
    }
}
