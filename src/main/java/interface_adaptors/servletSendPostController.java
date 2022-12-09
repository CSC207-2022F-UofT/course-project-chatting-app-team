package interface_adaptors;

import database_connection.*;
import post_reply_user.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sendPostGateway")
public class servletSendPostController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String postContent = req.getParameter("text");

        //Security: session to check if information is right
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("username");
        if(userName == null){
            resp.sendError(412,"Fail to send the post, wrong session!!!");
            return;
        }

        DatabaseInsert myDatabase = new DatabaseInsert(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
        myDatabase.insertPost(new Post(userName, postContent));

        myDatabase.close();
        req.getRequestDispatcher("/sendPostPresenter").forward(req,resp);
    }
}


