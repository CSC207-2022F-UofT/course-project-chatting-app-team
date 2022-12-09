package interface_adaptors;

import database_connection.DatabaseInsert;
import post_reply_user.Reply;
import send_reply_use_case.ReturnAsReply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// The servletSendReplyGateway class works as a gateway and pass variables to presenter.
@WebServlet("/sendReplyGateway")
public class servletSendReplyGateway extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        String id = req.getParameter("id");

        //Session security
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if(username == null){
            resp.sendError(412,"Fail to send the post, wrong session!!!");
            return;
        }


        DatabaseInsert myDatabase = new DatabaseInsert(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
        ReturnAsReply re = new ReturnAsReply();
        Reply reply = re.returnReply(username, id, text);
        myDatabase.insertReply(reply);
        myDatabase.close();
        req.getRequestDispatcher("/sendReplyResponse").forward(req,resp);
    }
}