package google.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import google.Bean.UserBean;
import google.Dao.UserDao;

@WebServlet("/Searchuser")
public class SearchUserController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String firstName=req.getParameter("firstName");
		
		ArrayList<UserBean> list=new UserDao().SearchUser(firstName);
		
		req.setAttribute("users", list);
		req.getRequestDispatcher("Searchdata.jsp").forward(req, resp);
	}
	
	

}
