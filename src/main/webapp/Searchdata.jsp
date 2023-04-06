
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   
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
   </tr>
   
   
   <c:forEach items="${users}" var="user">

   
   <tr>
       <td>${user.id}</td>
       <td>${user.firstName}</td>
       <td>${user.lastName}</td>
       <td>${user.emailId}</td>
       <td>${user.password}</td>
       <td>${user.city}</td>
       <td>${user.gender}</td>
       <td>${user.h1}</td>
       <td>${user.h2}</td>
       <td>${user.h3}</td>
       
    </tr>  
   
   </c:forEach>
         
</table>
<br><br>
<button><a href="ListController" style="text-decoration: none">List User</a></button>

</body>
</html>