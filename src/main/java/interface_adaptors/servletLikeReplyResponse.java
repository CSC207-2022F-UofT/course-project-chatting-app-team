package interface_adaptors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Not yet functioning (to be added later)
@WebServlet("/likeReplyResponse")
public class servletLikeReplyResponse extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = (String) req.getAttribute("status");
        resp.getWriter().append(status);
    }
}