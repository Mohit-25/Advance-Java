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
   UserBean user=(UserBean)request.getAttribute("user");
   %>

  FirstName: ${user.firstName}<br>
  LastName:${user.lastName}<br>
  EmailId:${user.emailId}<br>
  Password:${user.password}<br>
  Gender:${user.gender}<br>
  City:${user.city}<br>
  <%=user.getH1()==null?"": "Hobby1="+user.getH1()+"<br>" %>
  <%=user.getH2()==null?"": "Hobby2="+user.getH2()+"<br>" %>
  <%=user.getH3()==null?"": "Hobby3="+user.getH3()+"<br>" %>


<button ><a href="ListController" style="text-decoration: none">List User</a></button>

 
	
</body>
</html>