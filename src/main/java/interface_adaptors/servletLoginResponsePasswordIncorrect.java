package interface_adaptors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletLoginResponsePasswordIncorrect class works as a presenter and pass incorrect message back to front-end.
@WebServlet("/loginResponsePasswordIncorrect")
public class servletLoginResponsePasswordIncorrect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("incorrect");
    }
}