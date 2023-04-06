package google.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import google.Dao.UserDao;

@WebServlet("/DeleteController")
public class DeleteUserController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Integer userId=Integer.parseInt(req.getParameter("id")) ;
		
		new UserDao().deleteuser(userId);
		
		resp.sendRedirect("ListController");
		
	}

}
