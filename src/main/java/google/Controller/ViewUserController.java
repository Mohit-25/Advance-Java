package google.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import google.Bean.UserBean;
import google.Dao.UserDao;

@WebServlet("/ViewController")
public class ViewUserController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer userId=Integer.parseInt(req.getParameter("id")) ;
		
		
		UserBean user= new UserDao().getUserById(userId);
		
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("ViewUser.jsp").forward(req, resp);

	}

}
