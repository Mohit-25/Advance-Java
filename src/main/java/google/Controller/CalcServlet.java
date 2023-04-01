package google.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		int number_1 = Integer.parseInt(request.getParameter("value1"));
		int number_2 = Integer.parseInt(request.getParameter("value2"));
		String operation = request.getParameter("operation");
		
		response.setContentType("text/html"); // pdf audio video jpg html --> MIME type

		PrintWriter out=response.getWriter(); //Make a bridge between server and client browser
		
		
		out.print("<html><body>");
		
		if(operation.equals("add")) {
			System.out.println("Addition: "+(number_1+number_2));
			out.print(number_1 +" + " +number_2+ " = " +(number_1+number_2));
		}
		else if (operation.equals("sub")) {
			System.out.println("Subtraction: "+(number_1-number_2));
			out.print(number_1 +" - " +number_2+ " = " +(number_1-number_2));
		}
		else if (operation.equals("mul")) {
			System.out.println("Multiplication: "+(number_1*number_2));
			out.print(number_1 +" * " +number_2+ " = " +(number_1*number_2));
		}
		else if(operation.equals("div")){
			System.out.println("Division: "+(number_1/number_2));
			out.print(number_1 +" / " +number_2+ " = " +(number_1/number_2));
		}
		
		
		out.print("</body></html>");

		
	}
}