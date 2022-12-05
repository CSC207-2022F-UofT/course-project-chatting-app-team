package interfaceAdaptors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletLoginResponseSuccess class works as a presenter and pass success message back to front-end.
@WebServlet("/loginResponseSuccess")
public class servletLoginResponseSuccess extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("success");
    }
}
