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

@WebServlet("/Authentication")
public class AuthenticationController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		UserBean bean=new UserDao().Authenticate(email,password);
		RequestDispatcher rd=null;
		if(bean==null)
		{
			req.setAttribute("error", "Please Enter Valid Credentials...");
			rd=req.getRequestDispatcher("Login.jsp");
		}
		else
		{
			rd=req.getRequestDispatcher("Home.jsp");
		}
				
		rd.forward(req, resp);
	}
}
