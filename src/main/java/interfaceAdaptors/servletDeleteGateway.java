package interfaceAdaptors;

import database_connection.Database;

import database_connection.DatabaseDelete;
import database_connection.DatabaseRead;
import org.bson.Document;
import post_reply_user.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// The servletDeleteGateway class works as a gateway and pass variables to presenter.
@WebServlet("/deleteGateway")
public class servletDeleteGateway extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseRead myDatabase = new DatabaseRead(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));

        //Security: session to check if information is right
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        if(username == null){
            resp.sendError(412,"Fail to send the post, wrong session!!!");
            return;
        }

        String deleteId = req.getParameter("id");
        String status; //return status

        System.out.println(deleteId);
        Post post_sender = myDatabase.findPostById(deleteId);
        myDatabase.close();
        String sender = post_sender.getUserId();
        System.out.println(sender);
        if(sender.equals(username)){
            status = "success";
            DatabaseDelete databaseDelete = new DatabaseDelete(System.getenv("DatabaseConnectionString"), System.getenv("DatabaseCollection"));
            databaseDelete.deletePostById(deleteId);
            databaseDelete.close();
        }
        else {
            status = "fail";
        }
        req.setAttribute("status",status);
        System.out.println(status);
        req.getRequestDispatcher("/deleteResponse").forward(req,resp);
    }
}
