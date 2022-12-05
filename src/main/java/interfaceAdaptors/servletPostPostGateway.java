package interfaceAdaptors;

import database_connection.Database;
import database_connection.DatabaseInsert;
import post_post_use_case.ReturnAsPost;
import post_reply_user.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletPostPostGateway class works as a gateway and pass variables to presenter.
@WebServlet("/postPostGateway")
public class servletPostPostGateway extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = (String) req.getParameter("text");
        String userName = (String) req.getParameter("userName");
        DatabaseInsert myDatabase = new DatabaseInsert(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
        ReturnAsPost returnPost = new ReturnAsPost();
        Post post = returnPost.returnPost(userName, text);
        myDatabase.insertPost(post);
        myDatabase.close();
        req.getRequestDispatcher("/postPostResponse").forward(req,resp);
    }
}