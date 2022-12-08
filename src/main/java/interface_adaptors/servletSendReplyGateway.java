package interface_adaptors;

import database_connection.DatabaseInsert;
import post_reply_user.Reply;
import send_reply_use_case.ReturnAsReply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// The servletSendReplyGateway class works as a gateway and pass variables to presenter.
@WebServlet("/sendReplyGateway")
public class servletSendReplyGateway extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        String username = req.getParameter("username");
        String id = req.getParameter("id");

        DatabaseInsert myDatabase = new DatabaseInsert(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
        ReturnAsReply re = new ReturnAsReply();
        Reply reply = re.returnReply(username, id, text);
        myDatabase.insertReply(reply);
        myDatabase.close();
        req.getRequestDispatcher("/sendReplyResponse").forward(req,resp);
    }
}