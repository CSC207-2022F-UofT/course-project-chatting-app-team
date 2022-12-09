package interfaceAdaptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import database_connection.DatabaseRead;
import post_reply_user.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ser06")
public class servletSendPostPresenter extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        DatabaseRead myDatabase = new DatabaseRead(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));

        // Should probably move off this hardcoded 20 at some point
        List<Post> postDocs = myDatabase.findLatestPosts(20);

        ObjectMapper objectMapper = new ObjectMapper();

        String postsJsonString = objectMapper.writeValueAsString(postDocs);
        myDatabase.close();
        resp.getWriter().append(postsJsonString);
    }
}
