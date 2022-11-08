package com.xxxx.example;


import database_connection.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.ServletOutputStream;
import java.io.IOException;

//这个是测试文件
//创建java
//实现servlet的规范，继承httpserver
//重写service方法处理请求
//设置注解，指定访问的路径
@WebServlet(value = {"/ser01","/jingdong"})
public class Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello!");
        //通过输出数据到浏览器
        resp.getWriter().write("Hello There!");
        Database data = new Database("","");
    }
}
