package interface_adaptors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletRegisterResponse class works as a presenter and pass success message back to front-end.
@WebServlet("/registerResponse")
public class servletRegisterResponse extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("success");

        //This prevents people who continuously registers.
        Cookie cookie = new Cookie("recentlyRegister","yes");
        cookie.setMaxAge(300);
        resp.addCookie(cookie);
    }
}


