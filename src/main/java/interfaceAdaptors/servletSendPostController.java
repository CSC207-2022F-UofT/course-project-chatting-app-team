package interfaceAdaptors;

import database_connection.*;
import post_reply_user.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ser05")
public class servletSendPostController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String postContent = req.getParameter("text");
        String userName = req.getParameter("userName");

        DatabaseInsert myDatabase = new DatabaseInsert(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
        myDatabase.insertPost(new Post(userName, postContent));

        myDatabase.close();
        req.getRequestDispatcher("/ser06").forward(req,resp);
    }
}

