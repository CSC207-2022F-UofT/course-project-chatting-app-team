package interfaceAdaptors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

// The servletDeleteResponse class works as a presenter and pass message back to front-end.
@WebServlet("/deleteResponse")
public class servletDeleteResponse extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = (String) req.getAttribute("status");
        resp.getWriter().append(status);
    }
}
