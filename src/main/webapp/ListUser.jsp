<%@page import="java.util.ArrayList"%>
<%@page import="google.Bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%
  ArrayList<UserBean> users= (ArrayList<UserBean>) request.getAttribute("users");
  %>

<button><a href="SearchUser.jsp" >Search</a></button>
<br><br>

 <table border="1">
    <tr>
      <th>Id</th>
      <th>FirstName</th>
      <th>LastName</th>
      <th>EmailId</th>
      <th>Password</th>
      <th>City</th>
      <th>Gender</th>
      <th>Hobby1</th>
      <th>Hobby2</th>
      <th>Hobby3</th>
      <th>Action</th>
   </tr>
   
   <% for(UserBean bean:users){ %>
   
   <tr>
       <td><%=bean.getId() %></td>
       <td><%=bean.getFirstName() %></td>
       <td><%=bean.getLastName() %></td>
       <td><%=bean.getEmailId() %></td>
       <td><%=bean.getPassword() %></td>
       <td><%=bean.getCity() %></td>
       <td><%=bean.getGender() %></td>
       <td><%=bean.getH1() %></td>
       <td><%=bean.getH2() %></td>
       <td><%=bean.getH3() %></td>
       <td><a href="EditController?id=<%=bean.getId()%>">Edit</a>
       |
       <a href="ViewController?id=<%=bean.getId()%>">View</a>
       |
       <a href="DeleteController?id=<%=bean.getId()%>">Delete</a></td>
    </tr>  
   
   <% 
       } 
   %>
         
</table>
</body>
</html>