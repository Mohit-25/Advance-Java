package google.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import google.Bean.UserBean;
import google.Dao.UserDao;

@WebServlet("/EditController")
public class EditUserController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer userId=Integer.parseInt(req.getParameter("id")) ;

        UserBean user= new UserDao().getUserById(userId);
		
		req.setAttribute("user", user);

		req.getRequestDispatcher("EditUser.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		   Integer id=Integer.valueOf(req.getParameter("id"));
	       String firstName=req.getParameter("firstName");
	       String lastName=req.getParameter("lastName");
	       String city=req.getParameter("city");
	       String gender=req.getParameter("gender");
	       String h1=req.getParameter("h1");
	       String h2=req.getParameter("h2");
	       String h3=req.getParameter("h3");
	       
	       UserBean user=new UserBean();
	       user.setId(id);
	       user.setFirstName(firstName);
	       user.setLastName(lastName);
	       user.setCity(city);
           user.setGender(gender);
           user.setH1(h1);
           user.setH2(h2);
           user.setH3(h3);
           
	       new UserDao().UpdateUser(user);
	       
	       resp.sendRedirect("ListController");
	
	
	}

}
