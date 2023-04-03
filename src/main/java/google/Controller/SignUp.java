package google.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet
{

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String firstName = request.getParameter("firstName");
		String emailId= request.getParameter("emailId");
		String password = request.getParameter("password");
		
		response.setContentType("text/html"); // pdf audio video jpg html --> MIME type

		PrintWriter out=response.getWriter(); //Make a bridge between server and client browser
		out.print("<html><body>");
		
		String fn="[a-zA-Z]+";
		String em="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,3}$";
		String ps="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";
		boolean isError=false;
		StringBuffer error=new StringBuffer(" ");
		if(firstName==null || firstName.trim().length()==0)
		{
			isError=true;
			error.append("<br> Please Enter FirstName");
		}
		else if(firstName.matches(fn)==false)
		{
			isError=true;
			error.append("<br>Please Enter valid Name");
		}
		else if(firstName.trim().length()<=2)
		{
			isError=true;
			error.append("<br>Please Enter Atleast 2 Characters");
		}
		
		if(emailId==null || emailId.trim().length()==0)
		{
			isError=true;
			error.append("<br> Please Enter Email id");
		}
		else
		{
			if(emailId.matches(em)==false)
			{
			   isError=true;
			   error.append("<br>Please Enter valid Email Address");
			}
			
		}
		if(password==null || password.trim().length()==0)
		{
			isError=true;
			error.append("<br> Please Enter Password");
		}
		else 
		{
			if(password.matches(ps)==false)
			{
			isError=true;
			error.append("<br>Please Enter valid Password");
			}
			
		}
		
		if(isError)
		{
			out.print("<span style='color:red;'>" +error+"</span>");
		}
		else
		{
		    out.print("First Name : " +firstName);
		    out.print("First Name : " +emailId);
		    out.print("First Name : " +password);
         }
		
		
		out.print("</body></html>");

		
	}
}
