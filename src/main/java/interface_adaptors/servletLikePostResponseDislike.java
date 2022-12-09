package interface_adaptors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletLikePostResponseDislike class works as a presenter and pass dislike message back to front-end.
@WebServlet("/likePostResponseDislike")
public class servletLikePostResponseDislike extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("succeed to dislike");
    }
}