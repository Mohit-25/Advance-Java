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

@WebServlet("/ListController")
public class ListUsersController extends HttpServlet{
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       
		ArrayList<UserBean> list=UserDao.getAllrecords();
		
		req.setAttribute("users", list);
		req.getRequestDispatcher("ListUser.jsp").forward(req, resp);
	}
	
	

}
