<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="EditController" method="post">
   
     <input type="hidden" name="id" value="${param.id}"><br/>
     First Name: <input type="text" name="firstName" value="${user.firstName}"><br/><br/>
	 Last Name:  <input type="text" name="lastName" value="${user.lastName}"><br/><br/>
     City: <select name="city">
	        <option value="select">Select</option>
            <option  value="Ahmedabad">Ahmedabad</option>
            <option value="surat" >Surat</option>
            <option value="vadodara">Vadodara</option>
            </select><br/><br/>
	 Gender:<input type="radio" name="gender" value="m">Male
	       <input type="radio" name="gender" value="f">Female<br/><br/>
	 Hobby:<input type="checkbox" name="h1" value="cooking">Cooking
	       <input type="checkbox" name="h2" value="crafting">Crafting
	       <input type="checkbox" name="h3" value="dancing">Dancing<br/><br/>
	       
	       <input type="submit" value="Update">
	      
	  
</form>

</body>
</html>