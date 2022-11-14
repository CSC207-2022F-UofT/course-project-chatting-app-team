package com.xxxx.example;


import database_connection.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/k12") //可以通过此路径在网页访问到这个文件,比如  k125.love:8080/course_project_dating_app_team_Web_exploded/k12   ,
// 其中8080为端口,course_project_dating_app_team_Web_exploded为此project地址, k12此文件地址

//这是一个简单的如何接收数据示范,先实例化一个class,继承HttpServlet(一个Servlet class)
public class exampleServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //所有后端接收数据行为都在这里执行
        //1.前端会发送数据到这里，前端数据以"键值对"方式传递，即{key:value}形式
        // req是包含了前端传递所有信息,其中就包括数据
        //1.1 req传递的数据有可能是乱码,此行代码将乱码翻译成正常形式
        req.setCharacterEncoding("UTF-8");
        //1.2 此行代码展示如何从前端按key获取对应的value,其中key_name为键值对中的key名,注意:这里value是String,
        // 可以将value保存成其他形式,比如array,代码所示 (List<> array = new ArrayList<>; // array.append(value);)
        String value = req.getParameter("key_name");
        //1.3 此行代码展示如何获取前端路径信息(前端地址)
        String url = req.getRequestURL() + "";

        //2. 在这里接收数据之后,需要将数据传递到数据库中
        //2.1 此行代码展示如何传递到数据库中
        //生成数据库实例,其中 <connection string goes here> 需要改成数据库地址,其余无需改变
        Database myDatabase = new Database("<connection string goes here>", "DatingAppStaging");
        // 此行代码展示如何向数据库传递数据,前两行不要改变,后面可以更改, 基本语法为      .append(key:value),通常value填入之前获取的数据

        //2.2 获取数据,将“user_id”改为你所输入的id名

        //2.3 通常数据库返回document形式, 此处doc为document形式,我们需要转成String或其他java常见形式


        //3. 接收完数据库的数据后,将数据返回给前端
        //3.1 为了让前端不出现乱码,加入此行代码
        resp.setCharacterEncoding("utf-8");
        //3.2 向前端传回所需数据, 在append中填入你要传递的数据


    }
}
