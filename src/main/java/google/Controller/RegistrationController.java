package google.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import google.util.UserConnection;


@WebServlet("/registration")
public class RegistrationController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int record1=0;
		
		String firstName= req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String emailId=req.getParameter("emailId");
		String password=req.getParameter("password");
		String cpassword=req.getParameter("cpassword");
		String city=req.getParameter("city");
		String gender=req.getParameter("gender");
		String h1=req.getParameter("h1");
		String h2=req.getParameter("h2");
		String h3=req.getParameter("h3");
		
		
		resp.setContentType("text/html"); // pdf audio video jpg html --> MIME type

		PrintWriter out=resp.getWriter();
		
		out.print("<html><body>");
		
		String fn="[a-zA-Z]+";
		String em="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,3}$";
		String ps="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";
		boolean isError=false;
		StringBuffer error=new StringBuffer(" ");
		if(firstName==null || firstName.trim().length()==0)
		{
			isError=true;
//			error.append("<br> Please Enter FirstName");
			req.setAttribute("firstname", "Please Enter FirstName");
			
		}
		else if(firstName.matches(fn)==false)
		{
			isError=true;
//			error.append("<br>Please Enter valid Name");
			req.setAttribute("firstname", "Please Enter valid First Name");
			
		}
		else if(firstName.trim().length()<=2)
		{
			isError=true;
//			error.append("<br>Please Enter Atleast 2 Characters");
			req.setAttribute("firstname", "Please Enter Atleast 2 Characters");
		}
		
		if(lastName==null || lastName.trim().length()==0)
		{
			isError=true;
//			error.append("<br> Please Enter Last Name");
			req.setAttribute("lastname", "Please Enter Last Name");
		}
		else if(lastName.matches(fn)==false)
		{
			isError=true;
//			error.append("<br>Please Enter valid Name");
			req.setAttribute("lastname", "Please Enter valid Last Name");
		}
		else if(lastName.trim().length()<=2)
		{
			isError=true;
//			error.append("<br>Please Enter Atleast 2 Characters");
			req.setAttribute("lastname", "Please Enter Atleast 2 Characters");
		}
		
		
		if(emailId==null || emailId.trim().length()==0)
		{
			isError=true;
//			error.append("<br> Please Enter Email id");
			req.setAttribute("email", "Please Enter Email id");

		}
		else
		{
			if(emailId.matches(em)==false)
			{
			   isError=true;
//			   error.append("<br>Please Enter valid Email Address");
			   req.setAttribute("email", "Please Enter valid Email Address");

			}
			
		}
		if(password==null || password.trim().length()==0)
		{
			isError=true;
//			error.append("<br> Please Enter Password");
			req.setAttribute("password", "Please Enter Password");

		}
		else 
		{
			if(password.matches(ps)==false)
			{
			isError=true;
//			error.append("<br>Please Enter valid Password");
			   req.setAttribute("password", "Please Enter valid Password");

			}
			
		}
		
		if(!(cpassword.equals(password)))
		{
			isError=true;
//			error.append("<br>Please Enter same Password");
			req.setAttribute("cpassword", "Please Enter same Password");
			
		}
		
		if(city.equals("select"))
		{
			isError=true;
//			error.append("<br> Please Enter City");
			req.setAttribute("city", "Please Enter City");
			
		}
		
		if(gender==null)
			
		{
			isError=true;
//			error.append("<br> Please Enter Gender");
			req.setAttribute("gender", "Please Enter Gender");
			
		}
		
		if(h1==null && h2==null && h3==null)
		{
			isError=true;
//			error.append("<br> Please Enter At least one Hobby");
			req.setAttribute("hobby", "Please Enter At least one Hobby");
			
		}
		
		
		
		RequestDispatcher rd=null;
		
		if(isError)
		{
//			req.setAttribute("error", error.toString());
			rd=req.getRequestDispatcher("Registration.jsp");
			req.setAttribute("firstName", firstName);
			req.setAttribute("lastName", lastName);
			req.setAttribute("emailId",emailId);
			req.setAttribute("Password", password);
			req.setAttribute("Cpassword", cpassword);
			req.setAttribute("City", city);
			req.setAttribute("Gender", gender);
			req.setAttribute("H1", h1);
			req.setAttribute("H2", h2);
			req.setAttribute("H3", h3);

			
			
		}
		else
		{
			
			try {
				//store into database 
				Connection con = UserConnection.getConnection();
				//sql 
				//Statement
				//PreparedStatement
				//CallableStatement 
				PreparedStatement pstm = con.prepareStatement("insert into users(firstName,lastName,emailId,password,city,gender,h1,h2,h3) values (?,?,?,?,?,?,?,?,?) ");
				pstm.setString(1,firstName);
				pstm.setString(2, lastName);
				pstm.setString(3, emailId);
				pstm.setString(4, password);
				pstm.setString(5, city);
				pstm.setString(6, gender);
				pstm.setString(7, h1);
				pstm.setString(8, h2);
				pstm.setString(9, h3);
	
				record1 = pstm.executeUpdate(); //db -> 	1 -> inserted , updated , deleted 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			out.print("record= "+record1);
//			rd = req.getRequestDispatcher("Login.jsp");
			
			
//		    out.print("firstName= " +firstName);
//		    out.print("<br> lastName= " +lastName);
//		    out.print("<br> Email Id= " +emailId);
//		    out.print("<br> Password= " +password);
//		    out.print("<br> Confirm Password= " +cpassword);
//		    out.print("<br> City= " +city);
//		    out.print("<br> Gender= " +gender);
//		    
//		    if(h1!=null )
//		    {
//		    	out.print("<br> 1st Hobby = " +h1);
//		    }
//		    if(h2!=null )
//		    {
			
//		    	out.print("<br> 2nd Hobby = " +h2);
//		    }
//		    if(h3!=null )
//		    {
//		    	out.print("<br> 3rd Hobby= " +h3);
//		    }
		    
		
		
		
         }
		
		

		
		
		
		out.print("</body></html>");
		rd.forward(req, resp);
		
		
		
		
		
		
		
	}

}
