package interfaceAdaptors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletRegisterResponseUserExist class works as a presenter and pass invalid message back to front-end.
@WebServlet("/registerResponseUserExist")
public class servletRegisterResponseUserExist extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("username already exist");
    }
}